package duke.task;

/**
 * Represents tasks that are defined as events.
 */
public class Event extends Task {
    private String timeSlot;

    /**
     * Constructor for creating new Event objects.
     * @param name String that contains the name of event task to be created.
     * @param timeSlot String that contains the timing details of when the task occurs.
     */
    public Event(String name, String timeSlot) {
        super(name);
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return ("[Event]" + super.toString() + "( at: " + timeSlot + ")");
    }
}
