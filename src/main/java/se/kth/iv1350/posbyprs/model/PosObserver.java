package se.kth.iv1350.posbyprs.model;

/**
 * Receives notifications when payments are made and keeps track of the
 * total amount. It also prints out this value.
 */
public interface PosObserver {
    /**
     * Gets called when a payment has been made.
     * 
     * @param paymentAmount The amount paid. 
     */
    public void newPaymentMade(double paymentAmount);
}
