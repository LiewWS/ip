package duke.Exceptions;

public class DukeException extends Exception {
    private ExceptionType exType;

    public DukeException(ExceptionType exType) {
        this.exType = exType;
    }

    public String getMessage() {
        String msg;

        switch (exType) {
        case EMPTY_LIST:
            msg = "There are no tasks to list.";
            break;
        case NO_TODO_DESCRIPTION:
            msg = "Hey! Description of todo cannot be empty.";
            break;
        case NO_DEADLINE_DESCRIPTION:
            msg = "Hey! Description of deadline cannot be empty.";
            break;
        case NO_EVENT_DESCRIPTION:
            msg = "Hey! Description of event cannot be empty.";
            break;
        default:
            // Should not happen. Only create exceptions with valid types.
            msg = "uhh this is bad.";
        }

        return msg;
    }

    public ExceptionType getExType() {
        return exType;
    }
}
