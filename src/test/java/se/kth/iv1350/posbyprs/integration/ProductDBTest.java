package se.kth.iv1350.posbyprs.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;

/**
 *
 */
public class ProductDBTest {
    


    @Test
    public void testCallDatabaseWithoutConnection() {
        int productIdentifier = 999;
        ProductDB instance = new ProductDB();
        
        try {
            instance.getProductData(productIdentifier);
            fail("Operation continued despite connection failure");
        } catch (ProductDatabaseException ex) {
            assertTrue(ex.getProductIdentifier() == productIdentifier,
                    "The stored identifier does not match the used one.");
        }
        
    }
    
    @Test
    public void testCallDatabaseWithConnection() {
        int productIdentifier = 121;
        ProductDB instance = new ProductDB();
        
        try {
            instance.getProductData(productIdentifier);
        } catch (ProductDatabaseException ex) {
            fail("Connection exception thrown when not intended.");
        }
        
    }
    
    
    
}
