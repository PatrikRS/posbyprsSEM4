package se.kth.iv1350.posbyprs.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class displays appropriate error messages in the view.
 */
public class ErrorMessageHandler {
    
    /**
     * Displays an error message.
     * 
     * @param message The message to be displayed.
     */
    void displayErrorMessage (String message) {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("- ERROR - \n");
        errorMessage.append("Time and date: ");
        errorMessage.append(timeCreator());
        errorMessage.append("\nError message: ");
        errorMessage.append(message);
        System.out.println(errorMessage);
        System.out.println();
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
