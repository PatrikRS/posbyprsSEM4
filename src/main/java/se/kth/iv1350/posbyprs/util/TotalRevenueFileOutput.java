package se.kth.iv1350.posbyprs.util;

import se.kth.iv1350.posbyprs.model.PosObserver;

/**
 * An observer receiving notifications when a payment has been received.
 */
public class TotalRevenueFileOutput implements PosObserver {
    
    private double runningTotalPaidAmount;
    private ActualLogFileGenerator logGen;
    
    /**
     * Creates a new instance.
     */
    public TotalRevenueFileOutput() {
        logGen = new ActualLogFileGenerator();
    }
    
    /**
     * Updates the running total of received payments and creates a string
     * containing this information to be stored in a log.
     * 
     * @param paymentAmount The latest payment to be added to the total.
     */
    @Override
    public void newPaymentMade (double paymentAmount) {
        runningTotalPaidAmount += paymentAmount;
        logGen.storeMessageInLog("Total amount paid since program start: " +
                runningTotalPaidAmount);
    }
}
