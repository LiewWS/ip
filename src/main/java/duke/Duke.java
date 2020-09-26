package duke;

import duke.Exceptions.DukeException;
import duke.Exceptions.ExceptionTypes;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskType;
import duke.task.ToDo;

import static duke.task.TaskType.DEADLINE;
import static duke.task.TaskType.EVENT;
import static duke.task.TaskType.TODO;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private static final String DATA_FILE_PATH = "data/list_data.txt";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DukeList dList = new DukeList();
        Storage store = new Storage(DATA_FILE_PATH);

        try {
            store.readFromFile(dList);
        } catch (IOException ex) {
            printOutSingle(ex.getMessage());
        }
        String[] greet = {getLogo(), "Hello! I'm Duke", "What can I do for you?"};

        printOut(greet);
        while (true) {
            String cmd = scan.nextLine();
            String[] arguments = cmd.split(" ");
            try {
                if (arguments[0].equals("bye")) {
                    store.writeToFile(dList);
                    break;
                } else if (arguments[0].equals("list")) {
                    printOut(dList.listTasks());
                } else if (arguments[0].equals("done")) {
                    printOut(dList.markAsDone(Integer.valueOf(arguments[1])));
                } else if (arguments[0].equals("delete")) {
                    printOut(dList.deleteTask(Integer.valueOf(arguments[1])));
                } else if (arguments[0].equals("todo")) {
                    printOut(parseAdd(TODO, arguments, dList));
                } else if (arguments[0].equals("deadline")) {
                    printOut(parseAdd(DEADLINE, arguments, dList));
                } else if (arguments[0].equals("event")) {
                    printOut(parseAdd(EVENT, arguments, dList));
                } else {
                    printOutSingle("Woah hol up! That is not a valid command.");
                }
            } catch (DukeException | IndexOutOfBoundsException | IOException ex) {
                printOutSingle(ex.getMessage());
            }
        }
        printOutSingle("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the horizontal line divider.
     */
    public static void printDiv() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints each string on a separate line with one space indentation.
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
     * printOut for output that consists of only one line.
     * @param line String to be printed.
     */
    public static void printOutSingle(String line) {
        printDiv();
        System.out.println(" " + line);
        printDiv();
    }

    /**
     * Parse the command to add a task to duke.Duke List
     * @param type The type of task from task.TaskType to create.
     * @param args Array of Strings obtained from splitting a command by spaces.
     * @param dList duke.DukeList to add the task to.
     * @return Array of Strings to indicate result of adding task.
     */
    public static String[] parseAdd(TaskType type, String[] args, DukeList dList) throws DukeException {
        String name = "";
        String time = "";
        boolean isName = true;

        for (int i = 1; i < args.length; ++i) {
            if (args[i].equals("/by") || args[i].equals("/at")) {
                isName = false;
            } else if (isName) {
                // Concatenate to name
                name = name + args[i] + " ";
            } else {
                // Concatenate to time
                time = time + args[i] + " ";
            }
        }

        Task task = null;
        switch (type) {
        case TODO:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionTypes.NO_TODO_DESCRIPTION);
            }
            task = (Task) new ToDo(name);
            break;
        case DEADLINE:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionTypes.NO_DEADLINE_DESCRIPTION);
            }
            task = (Task) new Deadline(name, time);
            break;
        case EVENT:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionTypes.NO_EVENT_DESCRIPTION);
            }
            task = (Task) new Event(name, time);
            break;
        }
        // There are no other cases
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
