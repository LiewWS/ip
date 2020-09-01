import java.util.Scanner;

public class Duke {
    // Number of elements in in the array param to printOut in addition to list items.
    private static final int ADD_ELEMS = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DukeList dList = new DukeList();
        String[] greet = {getLogo(), "Hello! I'm Duke", "What can I do for you?"};
        String[] quit = {"Bye. Hope to see you again soon!"};

        printOut(greet);
        while (true) {
            String[] status = new String[dList.getListSize() + ADD_ELEMS];
            String cmd = scan.nextLine();
            if (cmd.equals("bye")) {
                break;
            }
            else if (cmd.equals("list")) {
                String[] list = dList.listTasks();
                if (list != null) {
                    printOut(list);
                }
            }
            else {
                String[] arguments = cmd.split(" ");
                if (arguments[0].equals("done")) {
                    status[0] = "Nice! You have completed the following item: ";
                    status[1] = dList.markAsDone(Integer.valueOf(arguments[1]));
                }
                else {
                    String[] details = parseAdd(arguments);

                    if (arguments[0].equals("todo")) {
                        ToDo todo = new ToDo(details[0]);
                        status[1] = todo.toString();
                        dList.addTask(todo);
                    }
                    else if (arguments[0].equals("deadline")) {
                        Deadline dead = new Deadline(details[0], details[1]);
                        status[1] = dead.toString();
                        dList.addTask(dead);
                    }
                    else if (arguments[0].equals("event")) {
                        Event event = new Event(details[0], details[1]);
                        status[1] = event.toString();
                        dList.addTask(event);
                    }
                    else {
                        status[1] = null;
                    }

                    status[0] = "Task added: ";
                    status[2] = dList.reportListSize();
                }
            }
            if (status[1] != null) {
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
            if (line != null) {
                System.out.println(" " + line);
            }
        }
        printDiv();
    }

    /**
     * Parse the command to add a task to Duke List
     * @param args Array of Strings obtained from splitting a command by spaces.
     * @return Array of Strings. 1st element is to task name. 2nd is timing info.
     */
    public static String[] parseAdd(String[] args) {
        String[] ret = {"", ""};
        boolean isName = true;

        for (int i = 1; i < args.length; ++i) {
            if (args[i].equals("/by") || args[i].equals("/at")) {
                isName = false;
            }
            else if (isName) {
                // Concatenate to first element that corresponds to name
                ret[0] = ret[0] + args[i] + " ";
            }
            else {
                // Concatenate to second element that corresponds to time
                ret[1] = ret[1] + args[i] + " ";
            }
        }

        return ret;
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
