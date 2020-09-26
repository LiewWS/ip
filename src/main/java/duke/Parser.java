package duke;

import duke.Command.*;
import duke.Exceptions.DukeException;
import duke.Exceptions.ExceptionType;
import duke.task.*;

public class Parser {
    private static final String STRING_EXIT = "bye";
    private static final String STRING_LIST = "list";
    private static final String STRING_DONE = "done";
    private static final String STRING_DELETE = "delete";
    private static final String STRING_TODO = "todo";
    private static final String STRING_DEADLINE = "deadline";
    private static final String STRING_EVENT = "event";
    private static final String STRING_FIND = "find";

    public static Command parseRaw(String rawCommand) throws DukeException {
        Command result;
        int index;
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
            index = Integer.valueOf(arguments[1]);
            result = new DoneCommand(index);
            break;
        case STRING_DELETE:
            index = Integer.valueOf(arguments[1]);
            result = new DeleteCommand(index);
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
        case STRING_FIND:
            String keyword = reconstructKeyword(arguments);
            result = new FindCommand(keyword);
            break;
        default:
            result = new InvalidCommand();
        }
        return result;
    }

    /**
     * Parse the command to add a task to duke.Duke List
     * @param type The type of task from task.TaskType to create.
     * @param args Array of Strings obtained from splitting a command by spaces.
     * @return Array of Strings to indicate result of adding task.
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

    private static String reconstructKeyword(String[] words) {
        String keyword = "";
        for (int i = 1; i < words.length; ++i) {
            keyword += words[i] + " ";
        }
        return keyword.trim();
    }
}
