package se.kth.iv1350.posbyprs.controller;

/**
 * Thrown when trying to find item with an identifier that
 * does not exist in the database.
 */
public class InvalidIdentifierException extends Exception {
    private int productIdentifier;
    
    /**
     * Creates an instance with a message explaining 
     * the issue and displaying the invalid identifier.
     * 
     * @param invalidIdentifier The invalid identifier.
     */
    public InvalidIdentifierException(int productIdentifier) {
        super("Item with identifier " + productIdentifier +
                " could not be found.");
        this.productIdentifier = productIdentifier;
    }
    
    /**
     * Returns the invalid identifier which caused the exception.
     * 
     * @return The invalid identifier which caused the exception.
     */
    public int getProductIdentifier() {
        return productIdentifier;
    }
}
