package duke;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

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
}
