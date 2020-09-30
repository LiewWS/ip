package duke.task;

/**
 * Represents tasks that are defined as deadlines.
 */
public class Deadline extends Task {
    private String dateTime;

    /**
     * Constructor for creating new Deadline objects.
     * @param name String that contains the name of deadline task to be created.
     * @param dateTime String that contains the timing details of when the task must be completed by.
     */
    public Deadline(String name, String dateTime) {
        super(name);
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return ("[Deadline]" + super.toString() + "( by: " + dateTime + ")");
    }
}
