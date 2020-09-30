package duke.Exceptions;

/**
 * Represents errors that can occur in the execution of the Duke program
 */
public class DukeException extends Exception {
    private ExceptionType exType;

    /**
     * Constructor for creating a new DukeException object
     * @param exType type of error encountered. Refer to the ExceptionType enum class
     *               for valid types of exception.
     */
    public DukeException(ExceptionType exType) {
        this.exType = exType;
    }

    /**
     * Retrieves the appropriate message according to the type of error encountered.
     * @return String that describes the problem to the user.
     */
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
        case BAD_INDEX:
            msg = "The index that you are looking for is unavailable.";
            break;
        case ITEM_NOT_FOUND:
            msg = "Search returned 0 results.";
            break;
        default:
            // Should not happen. Only create exceptions with valid types.
            msg = "uhh this is bad.";
        }

        return msg;
    }

    /**
     * Getter method for checking the ExceptionType of the object.
     * @return ExceptionType of the current object.
     */
    public ExceptionType getExType() {
        return exType;
    }
}
