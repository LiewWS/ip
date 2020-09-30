package duke;

import java.util.Scanner;

/**
 * Represents the user interface of the program.
 * Handles I/O to console.
 */
public class Ui {
    private static final String[] GREETING = {Duke.getLogo(), "Hello, I am Duke", "What can I do for you?"};
    private static final String FAREWELL = "Bye. Hope to see you again soon!";
    private Scanner scanner;

    /**
     * Constructor to create a new Ui object.
     * Creates a scanner for reading input to program.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads a line from the console.
     * @return
     */
    public String readLine() {
        return scanner.nextLine();
    }

    /**
     * Prints the horizontal line divider.
     */
    private void printDiv() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints each string on a separate line with one space indentation.
     * Starts and ends the group of output with a horizontal line divider.
     * @param lines Array of Strings to be printed on separate lines.
     */
    public void printOut(String[] lines) {
        printDiv();
        for (String line : lines) {
            if (line == null) {
                break;
            }
            System.out.println(" " + line);
        }
        printDiv();
    }

    /**
     * printOut for output that consists of only one line.
     * @param line String to be printed.
     */
    public void printOutSingle(String line) {
        printDiv();
        System.out.println(" " + line);
        printDiv();
    }

    /**
     * Print to console the message for greeting user.
     */
    public void greet() {
        printOut(GREETING);
    }

    /**
     * Print to console the message when user exits.
     */
    public void bidFarewell() {
        printOutSingle(FAREWELL);
    }
}
