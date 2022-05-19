package se.kth.iv1350.posbyprs.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posbyprs.integration.ExternalSystemCaller;
import se.kth.iv1350.posbyprs.integration.Printer;
import se.kth.iv1350.posbyprs.integration.ProductDB;
import se.kth.iv1350.posbyprs.integration.ProductDatabaseException;
import se.kth.iv1350.posbyprs.integration.Register;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;

/**
 *
 * @author patri
 */
public class ControllerTest {
    




    @Test
    public void testFindIdentifierThatDoesNotExist()
                        throws UnsuccessfulOperationException {
        ExternalSystemCaller extSysCall = new ExternalSystemCaller();
        ProductDB productDB = new ProductDB();
        Register register = new Register();
        Printer printer = new Printer();
        Controller instance = new Controller(extSysCall, productDB,
                                                register, printer);
        int invalidProductIdentifier = 448;
        
        try {
            instance.scanProduct(invalidProductIdentifier);
            fail("Could enter an invalid product identifier.");
        } catch (InvalidIdentifierException ex) {
            assertTrue(ex.getMessage().contains(
                    Integer.toString(
                    ex.getProductIdentifier())),
                    "Error message does not contain identifier: " +
                    ex.getMessage());
            assertTrue(ex.getProductIdentifier() == (invalidProductIdentifier),
                    "The wrong identifier is stored in the exception.");
        }
    }
    
    @Test
    public void testScanProductWithConnectionFailure() 
                    throws InvalidIdentifierException {
        ExternalSystemCaller extSysCall = new ExternalSystemCaller();
        ProductDB productDB = new ProductDB();
        Register register = new Register();
        Printer printer = new Printer();
        Controller instance = new Controller(extSysCall, productDB,
                                                register, printer);
        
        int productIdentifier = 999;
        
        try {
            instance.scanProduct(productIdentifier);
            fail("Could continue operation despite failing communication" + 
                    "with database.");
        } catch (UnsuccessfulOperationException ex) {
            assertTrue(ex.getCause() instanceof ProductDatabaseException,
                    "Wrong type of exception stored as cause.");
        }
    }
    
    @Test
    public void testFindIdentifierThatExists()
                        throws UnsuccessfulOperationException {
        ExternalSystemCaller extSysCall = new ExternalSystemCaller();
        ProductDB productDB = new ProductDB();
        Register register = new Register();
        Printer printer = new Printer();
        Controller instance = new Controller(extSysCall, productDB,
                                                register, printer);
        int validProductIdentifier = 449;
        
        try {
            instance.scanProduct(validProductIdentifier);
        } catch (InvalidIdentifierException ex) {
            fail("Invalid identifier exception thrown when entering"
                    + "a valid identifier.");
        } catch (NullPointerException ex) {
            
        }
    }
    
}
