/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.posbyprs.controller;

/**
 * Thrown from the controller to the view when something happens
 * that causes the operation to fail.
 */
public class UnsuccessfulOperationException extends Exception {
    
    
    /**
     * Creates a new instance of the exception.
     * 
     * @param message The message explaining why the exception occurred.
     * 
     * @param cause The exception which caused this exception.
     */
    public UnsuccessfulOperationException(String message, Exception cause) {
        super(message, cause);
    }
}
