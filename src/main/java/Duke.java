public class Duke {
    public static void main(String[] args) {
        String[] greet = {"Hello! I'm Duke", "What can I do for you?"};
        String[] quit = {"Bye. Hope to see you again soon!"};

        printDiv();
        printOut(greet);
        printOut(quit);
    }

    // Prints the horizontal line divider.
    public static void printDiv() {
        System.out.println("____________________________________________________________");
    }

    // Prints each string in the array on a separate line with one space indentation.
    // Ends the group of output with a horizontal line divider.
    // Parameters: lines is an array of Strings to be printed on separate lines.
    public static void printOut(String[] lines) {
        for (String line : lines) {
            System.out.println(" " + line);
        }
        printDiv();
    }

    // System.out.println(getLogo()) prints the logo.
    // Returns a String that can be printed directly to print the logo.
    public static String getLogo() {
        return (" ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
    }
}
