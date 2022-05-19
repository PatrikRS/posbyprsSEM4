package se.kth.iv1350.posbyprs.view;

import se.kth.iv1350.posbyprs.model.PosObserver;

/**
 * An observer receiving notifications when a payment has been received.
 */
public class TotalRevenueView implements PosObserver {
    
    private double runningTotalPaidAmount;
    
    /**
     * Updates the running total of received payments and creates a string
     * containing this information to be displayed in the view.
     * 
     * @param paymentAmount The latest payment to be added to the total.
     */
    @Override
    public void newPaymentMade (double paymentAmount) {
        runningTotalPaidAmount += paymentAmount;
        System.out.println();
        System.out.println("---- OBSERVER VIEW ----");
        System.out.println("Total amount paid since program start: " +
                runningTotalPaidAmount);
        System.out.println();
    }
}
