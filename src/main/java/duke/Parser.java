package duke;

import duke.Command.*;
import duke.Exceptions.DukeException;
import duke.Exceptions.ExceptionType;
import duke.task.*;

/**
 * Parses the String inputs from the user to determine command to be executed.
 */
public class Parser {
    private static final String STRING_EXIT = "bye";
    private static final String STRING_LIST = "list";
    private static final String STRING_DONE = "done";
    private static final String STRING_DELETE = "delete";
    private static final String STRING_TODO = "todo";
    private static final String STRING_DEADLINE = "deadline";
    private static final String STRING_EVENT = "event";

    /**
     * The main method used to determine the command to execute based on the String supplied.
     * @param rawCommand String to be parsed for valid commands.
     * @return Command object that can be executed to carry out instruction intended by user.
     * @throws DukeException from parseAdd.
     * @throws NumberFormatException when converting a string to an integer fails.
     */
    public static Command parseRaw(String rawCommand) throws DukeException, NumberFormatException {
        Command result;
        int serialNum;
        String name;
        String time;

        String[] arguments = rawCommand.split(" ");
        switch (arguments[0].toLowerCase()) {
        case STRING_EXIT:
            result = new ExitCommand();
            break;
        case STRING_LIST:
            result = new ListCommand();
            break;
        case STRING_DONE:
            serialNum = Integer.valueOf(arguments[1]);
            result = new DoneCommand(serialNum);
            break;
        case STRING_DELETE:
            serialNum = Integer.valueOf(arguments[1]);
            result = new DeleteCommand(serialNum);
            break;
        case STRING_TODO:
            result = parseAdd(TaskType.TODO, arguments);
            break;
        case STRING_DEADLINE:
            result = parseAdd(TaskType.DEADLINE, arguments);
            break;
        case STRING_EVENT:
            result = parseAdd(TaskType.EVENT, arguments);
            break;
        default:
            result = new InvalidCommand();
        }
        return result;
    }

    /**
     * Parse the array of Strings to find the name and time details of the task to be created
     * assuming that the correct task type is specified.
     * @param type The type of task from task.TaskType to create.
     * @param args Array of Strings obtained from splitting a command by spaces.
     * @return Command object that can be executed to carry out instruction intended by user.
     * @throws DukeException if a task to be added has no name.
     */
    private static Command parseAdd(TaskType type, String[] args) throws DukeException {
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

        Command cmd = null;
        switch (type) {
        case TODO:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionType.NO_TODO_DESCRIPTION);
            }
            cmd = new TodoCommand(name);
            break;
        case DEADLINE:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionType.NO_DEADLINE_DESCRIPTION);
            }
            cmd = new DeadlineCommand(name, time);
            break;
        case EVENT:
            if (name.isEmpty()) {
                throw new DukeException(ExceptionType.NO_EVENT_DESCRIPTION);
            }
            cmd = new EventCommand(name, time);
            break;
        }
        // There are no other cases
        return cmd;
    }
}
