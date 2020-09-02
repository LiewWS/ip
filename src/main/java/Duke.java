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
                String[] list = dList.listTasks();
                if (list != null) {
                    printOut(list);
                }
            }
            else {
                String[] arguments = cmd.split(" ");
                String[] status;

                if (arguments[0].equals("done")) {
                    status = dList.markAsDone(Integer.valueOf(arguments[1]));
                }
                else {
                    status = parseAdd(arguments, dList);
                }

                if (status != null) {
                    printOut(status);
                }
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
            if (line == null) {
                break;
            }
            System.out.println(" " + line);
        }
        printDiv();
    }

    /**
     * Parse the command to add a task to Duke List
     * @param args Array of Strings obtained from splitting a command by spaces.
     * @param dList DukeList to add the task to.
     * @return Array of Strings to indicate result of adding task. Null indicates error.
     */
    public static String[] parseAdd(String[] args, DukeList dList) {
        String name = "";
        String time = "";
        Task task;
        boolean isName = true;

        for (int i = 1; i < args.length; ++i) {
            if (args[i].equals("/by") || args[i].equals("/at")) {
                isName = false;
            }
            else if (isName) {
                // Concatenate to first element that corresponds to name
                name = name + args[i] + " ";
            }
            else {
                // Concatenate to second element that corresponds to time
                time = time + args[i] + " ";
            }
        }

        if (args[0].equals("todo")) {
            task = (Task) new ToDo(name);
        }
        else if (args[0].equals("deadline")) {
            task = (Task) new Deadline(name, time);
        }
        else if (args[0].equals("event")) {
            task = (Task) new Event(name, time);
        }
        else {
            return null;
        }
        
        dList.addTask(task);
        return new String[] {"Task added: ", task.toString(), dList.reportListSize()};
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
