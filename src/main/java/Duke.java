import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DukeList dList = new DukeList();
        String[] greet = {getLogo(), "Hello! I'm Duke", "What can I do for you?"};
        String[] quit = {"Bye. Hope to see you again soon!"};

        printOut(greet);
        while (true) {
            String cmd = scan.nextLine();
            if (cmd.equals("bye")) {
                break;
            }
            else if (cmd.equals("list")) {
                String[] list = dList.listItems();
                if (list != null) {
                    printOut(list);
                }
            }
            else if (cmd.contains("done")) {
                String[] arguments = cmd.split(" ");
                String[] status = {"Nice! You have completed the following item: ",
                        dList.markAsDone(Integer.valueOf(arguments[1]))};
                if (status[1] != null) {
                    printOut(status);
                }
            }
            else {
                dList.addItem(cmd);
                String[] status = {"added: " + cmd};
                printOut(status);
            }
        }
        printOut(quit);
    }

    /**
     * Prints the horizontal line divider.
     */
    public static void printDiv() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints each string in the array on a separate line with one space indentation.
     * Starts and ends the group of output with a horizontal line divider.
     * @param lines Array of Strings to be printed on separate lines.
     */
    public static void printOut(String[] lines) {
        printDiv();
        for (String line : lines) {
            System.out.println(" " + line);
        }
        printDiv();
    }

    /**
     * System.out.println(getLogo()) prints the logo.
     * @return String that can be printed directly to print the logo.
     */
    public static String getLogo() {
        return ("____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
    }
}
