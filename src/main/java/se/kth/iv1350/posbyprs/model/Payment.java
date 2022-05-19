package se.kth.iv1350.posbyprs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Information regarding one payment received.
 */
public class Payment {
    private double paidAmount;
    private double changeAmount;
    private List<PosObserver> posObservers = new ArrayList<>();
    
    /**
     * Creates a new instance of Payment.
     * 
     * @param paidAmount The amount paid.
     * @param totalInclVat The total cost of the sale.
     */
    public Payment(double paidAmount, double totalInclVat) {
        this.paidAmount = paidAmount;
        this.changeAmount = paidAmount - totalInclVat;
    }

    /**
     * @return The change to be provided to the customer.
     */
    public double getChangeAmount() {
        return changeAmount;
    }
    

    /**
     * Notifies the observers added to the observer list.
     */
    private void notifyObservers() {
        for (PosObserver obs : posObservers) {
            obs.newPaymentMade(paidAmount);
        }
    }


    
    /**
     * Adds observer(s) to the observer list and calls the method
     * notifying the observers.
     * 
     * @param posObservers The observers to be added.
     */
    public void addObserversToList (List<PosObserver> posObservers) {
        for (PosObserver obs : posObservers) {
            this.posObservers.add(obs);
        }
        notifyObservers();
    }
    
    
    
}
