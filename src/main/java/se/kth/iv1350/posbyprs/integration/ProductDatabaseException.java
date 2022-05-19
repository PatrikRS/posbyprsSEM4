package se.kth.iv1350.posbyprs.integration;

/**
 * Thrown whenever an issue occurs while trying to
 * communicate with the product database.
 * 
 * @param productIdentifier The product identifier used when the
 * exception was thrown.
 */
public class ProductDatabaseException extends RuntimeException {
    
    private int productIdentifier;
    
    /**
     * Creates a new instance of the exception.
     * 
     * @param message A message describing why the exception was thrown.
     */
    public ProductDatabaseException(String message, int productIdentifier) {
        super(message);
        this.productIdentifier = productIdentifier;
    }
    
    /**
     * Returns the product identifier used when the exception was thrown.
     * 
     * @return The product identifier used when the exception was thrown.
     */
    public int getProductIdentifier() {
        return productIdentifier;
    }
}
