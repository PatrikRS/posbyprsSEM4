package se.kth.iv1350.posbyprs.view;

import se.kth.iv1350.posbyprs.controller.Controller;
import se.kth.iv1350.posbyprs.controller.InvalidIdentifierException;
import se.kth.iv1350.posbyprs.controller.UnsuccessfulOperationException;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;
import se.kth.iv1350.posbyprs.util.LogGenerator;
import se.kth.iv1350.posbyprs.util.TotalRevenueFileOutput;

/**
 * This class represents the entire view of the program. All system calls
 * will be hardcoded here.
 * @author Patrik
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorMessageHandler =
            new ErrorMessageHandler();
    private LogGenerator logGenerator = new LogGenerator();
    
    /**
     * Creates a new instance of the view which makes calls to the
     * specified controller.
     * 
     * @param contr The controller which receives the calls.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addObserverToList(new TotalRevenueView());
        contr.addObserverToList(new TotalRevenueFileOutput());
    }
    
    /**
     * Simulates an execution of the program without user input.
     */
    public void runDummyExecution() {
        
        /* This section simulates entering an invalid identifier */
        try {
            SaleInformationDTO saleInfo;
            contr.initiateNewSale();
            System.out.println("New sale initiated.");
            saleInfo = contr.scanProduct(121);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(544);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(255);
            displaySaleInfo(saleInfo);
            /* 448 is an invalid product identifier */
            saleInfo = contr.scanProduct(448);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);

            double totalInclVat = contr.endSale();
            System.out.println("-- Sale ended --");
            System.out.println("Total cost: " + totalInclVat);
            System.out.println();

            double changeAmount = contr.enterPayment(200, totalInclVat);
            System.out.println("Change: " + changeAmount);
        } catch (InvalidIdentifierException ex) {
            errorMessageHandler.displayErrorMessage("The identifier " 
            + ex.getProductIdentifier() + " is invalid. Please try again.");
        } catch (UnsuccessfulOperationException ex) {
            sendExceptionInformationToLogAndDisplay("Communication with " 
            + "the product database failed. Please check your connection "
            + "and try again.", ex);
        } catch (Exception ex) {
            sendExceptionInformationToLogAndDisplay("An issue occurred, " 
            + "please try again.", ex);
        }
        
        /* This section simulates a database communication failure */
        try {
            SaleInformationDTO saleInfo;
            contr.initiateNewSale();
            System.out.println("New sale initiated.");
            saleInfo = contr.scanProduct(121);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(544);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(255);
            displaySaleInfo(saleInfo);
            /* 999 represents a database connection failure */
            saleInfo = contr.scanProduct(999);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);

            double totalInclVat = contr.endSale();
            System.out.println("-- Sale ended --");
            System.out.println("Total cost: " + totalInclVat);
            System.out.println();

            double changeAmount = contr.enterPayment(200, totalInclVat);
            System.out.println("Change: " + changeAmount);
        } catch (InvalidIdentifierException ex) {
            errorMessageHandler.displayErrorMessage("The identifier " 
            + ex.getProductIdentifier() + " is invalid. Please try again.");
        } catch (UnsuccessfulOperationException ex) {
            sendExceptionInformationToLogAndDisplay("Communication with " 
            + "the product database failed. Please check your connection "
            + "and try again.", ex);
        } catch (Exception ex) {
            sendExceptionInformationToLogAndDisplay("An issue occurred, " 
            + "please try again.", ex);
        }
        
        /* This section simulates a successful run through the program
        *  to showcase the observer functionalities.
        */
        try {
            SaleInformationDTO saleInfo;
            contr.initiateNewSale();
            System.out.println("New sale initiated.");
            saleInfo = contr.scanProduct(121);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(544);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(255);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);

            double totalInclVat = contr.endSale();
            System.out.println("-- Sale ended --");
            System.out.println("Total cost: " + totalInclVat);
            System.out.println();

            double changeAmount = contr.enterPayment(200, totalInclVat);
            System.out.println("Change: " + changeAmount);
        } catch (InvalidIdentifierException ex) {
            errorMessageHandler.displayErrorMessage("The identifier " 
            + ex.getProductIdentifier() + " is invalid. Please try again.");
        } catch (UnsuccessfulOperationException ex) {
            sendExceptionInformationToLogAndDisplay("Communication with " 
            + "the product database failed. Please check your connection "
            + "and try again.", ex);
        } catch (Exception ex) {
            sendExceptionInformationToLogAndDisplay("An issue occurred, " 
            + "please try again.", ex);
        }
        
        
        /* This section simulates a successful run through the program
        *  to showcase the observer functionalities.
        */
        try {
            SaleInformationDTO saleInfo;
            contr.initiateNewSale();
            System.out.println("New sale initiated.");
            saleInfo = contr.scanProduct(121);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(544);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(255);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(449);
            displaySaleInfo(saleInfo);
            saleInfo = contr.scanProduct(857);
            displaySaleInfo(saleInfo);

            double totalInclVat = contr.endSale();
            System.out.println("-- Sale ended --");
            System.out.println("Total cost: " + totalInclVat);
            System.out.println();

            double changeAmount = contr.enterPayment(200, totalInclVat);
            System.out.println("Change: " + changeAmount);
        } catch (InvalidIdentifierException ex) {
            errorMessageHandler.displayErrorMessage("The identifier " 
            + ex.getProductIdentifier() + " is invalid. Please try again.");
        } catch (UnsuccessfulOperationException ex) {
            sendExceptionInformationToLogAndDisplay("Communication with " 
            + "the product database failed. Please check your connection "
            + "and try again.", ex);
        } catch (Exception ex) {
            sendExceptionInformationToLogAndDisplay("An issue occurred, " 
            + "please try again.", ex);
        }
        
        
    }
    
    /**
     * Method for printing the information stored in saleInfo.
     * 
     * @param saleInfo DTO with sale information to be printed.
     */
    private void displaySaleInfo(SaleInformationDTO saleInfo) {
        System.out.println("Item scanned successfully.\n");
        System.out.println("Description: " + saleInfo.getDescription());
        System.out.println("Price: " + saleInfo.getPriceInclVat());
        System.out.println("Total: " + saleInfo.getRunningTotal() + "\n");
    }
    
    /**
     * Receives exception information and forwards it to be logged and
     * displayed.
     * 
     * @param messageForDisplay The message to be displayed.
     * @param ex The exception to be logged.
     */
    private void sendExceptionInformationToLogAndDisplay(
                String messageForDisplay, Exception ex) {
        errorMessageHandler.displayErrorMessage(messageForDisplay);
        logGenerator.saveExceptionToLog(ex);
    }
}
