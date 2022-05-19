package se.kth.iv1350.posbyprs.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class receives information about exceptions and generates a log of them.
 * In this version of the program, the log is simply printed to System.out.
 * 
 */
public class LogGenerator {

    /**
     * Simulates saving information about an exception to the log. In this
     * version, the information which would have been logged is printed to
     * System.out.
     * 
     * @param ex The exception to be logged.
     */
    public void saveExceptionToLog(Exception ex) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("---- LOG SIMULATION START ---- \n");
        logMessage.append("Time and date: ");
        logMessage.append(timeCreator());
        logMessage.append("\nError message: ");
        logMessage.append(ex.getMessage());
        logMessage.append("\n---- STACK TRACE STARTS HERE ---- \n");
        System.out.println(logMessage);
        ex.printStackTrace();
        System.out.println("---- LOG SIMULATION END ---- \n");
    }

     /**
     * Creates a string containing the current time and date.
     * 
     * @return The current time and date.
     */
    private String timeCreator() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.MEDIUM);
        return currentTime.format(formatter);
    }

}
