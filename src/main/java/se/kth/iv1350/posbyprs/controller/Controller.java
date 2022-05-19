package se.kth.iv1350.posbyprs.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posbyprs.integration.ExternalSystemCaller;
import se.kth.iv1350.posbyprs.integration.Printer;
import se.kth.iv1350.posbyprs.integration.ProductDB;
import se.kth.iv1350.posbyprs.integration.ProductDatabaseException;
import se.kth.iv1350.posbyprs.integration.Register;
import se.kth.iv1350.posbyprs.model.Payment;
import se.kth.iv1350.posbyprs.model.PosObserver;
import se.kth.iv1350.posbyprs.model.Sale;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * This is the application's controller which handles all calls to
 * both the model and the integration. It receives all calls from
 * the view.
 */
public class Controller {
    private Sale sale;
    private ExternalSystemCaller extSysCall;
    private ProductDB productDB;
    private Register register;
    private SaleLogDTO saleLogDTO;
    private Printer printer;
    private List<PosObserver> posObservers = new ArrayList<>();
    
    /**
     * Creates a new instance of Controller.
     * 
     * @param extSysCall Reference to ExternalSystemCaller.
     * @param productDB Reference to ProductDB.
     * @param register Reference to Register.
     * @param printer Reference to Printer.
     */
    public Controller(ExternalSystemCaller extSysCall, ProductDB productDB,
            Register register, Printer printer) {
        this.extSysCall = extSysCall;
        this.productDB = productDB;
        this.register = register;
        this.printer = printer;
    }
    
    /**
     * Adds a PosObserver object to the list.
     * 
     * @param posObserver The observer to be added.
     */
    public void addObserverToList (PosObserver posObserver) {
        posObservers.add(posObserver);
    }
    
    /**
     * Initiates a new sale.
     */
    public void initiateNewSale() {
        sale = new Sale();
    }
    
    /**
     * Scans a product and retrieves information about it.
     * 
     * @param productIdentifier Unique identifier for the scanned product.
     * 
     * @return Collection of data to be displayed in the view.
     * 
     * @throws InvalidIdentifierException When an identifier could not
     * be found in the database.
     * 
     * @throws UnsuccessfulOperationException When communication with
     * the database failed.
     */
    public SaleInformationDTO scanProduct(int productIdentifier)
                        throws InvalidIdentifierException,
                                UnsuccessfulOperationException {
        
        try {
            ProductDTO prodDTO = productDB.getProductData(productIdentifier);
            if (prodDTO == null) {
                throw new InvalidIdentifierException(productIdentifier);
            }
            return(sale.updateSale(prodDTO));
        } catch (ProductDatabaseException ex) {
            throw new UnsuccessfulOperationException("Communication with the" +
                                            " product database failed.", ex);
        }
        
    }
    
    /**
     * Ends the sale and retrieves the total sale cost.
     * 
     * @return Total cost of the sale (including VAT).
     */
    public double endSale() {
        return sale.getTotalSaleCost();
    }
    
    /**
     * Registers payment and retrieves the change amount.
     * 
     * @param paidAmount The paid amount.
     * 
     * @param totalInclVat The total cost of the sale (including VAT).
     * 
     * @return The change amount to be provided to the client.
     */
    public double enterPayment(double paidAmount, double totalInclVat) {
        Payment payment = new Payment(paidAmount, totalInclVat);
        payment.addObserversToList(posObservers);
        saleLogDTO = sale.createSaleLog(paidAmount, payment.getChangeAmount());
        
        extSysCall.sendInformationToExternalInventorySystem(saleLogDTO);
        extSysCall.sendInformationToExternalAccountingSystem(saleLogDTO);
        
        register.updateBalance(paidAmount, totalInclVat);
        
        printer.printReceipt(saleLogDTO);
        
        return payment.getChangeAmount();
    }
}
