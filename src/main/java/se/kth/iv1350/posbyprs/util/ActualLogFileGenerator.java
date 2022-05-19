package se.kth.iv1350.posbyprs.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class creates a text-file with provided information.
 */
public class ActualLogFileGenerator {
    
    private PrintWriter logStream;
    private static final String FILE_NAME = "log-for-task2-sem4.txt";
    
    
    /**
     * Creates a new instance.
     */
    public ActualLogFileGenerator() {
        try {
            logStream = new PrintWriter(new FileWriter(FILE_NAME), true);
        } catch (IOException ex) {
            System.out.println("Could not create new file logger.");
            ex.printStackTrace();
        }
    }
    
    /**
     * Receives a message and stores it in a text file.
     * 
     * @param message The message to be stored.
     */
    public void storeMessageInLog(String message) {
        logStream.println(message);
    }
}
