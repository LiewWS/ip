package duke.task;

/**
 * Represents tasks with a name and completion status.
 * Extended by ToDo, Deadline and Event.
 */
public abstract class Task {
    private String name;
    private boolean isDone;

    /**
     * Constructor for creating objects that represent tasks that have a name.
     * The task is marked as uncompleted upon creation.
     * @param name String that describes the task.
     */
    protected Task(String name) {
        this.name = name;
        isDone = false;
    }

    /**
     * Mark a task as completed.
     */
    public void setIsDone() {
        isDone = true;
    }

    /**
     * Getter method for obtaining the name of a task.
     * @return String that is the name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for checking if a task is done
     * @return True if task is done, otherwise False.
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Formats details of the task as a String. The format is as follows:
     * [<Y/N>] <name>
     * where Y indicates that the task is completed and N indicates that the task is not completed.
     * @return String that can be printed to display details of the task.
     */
    @Override
    public String toString() {
        return ("[" + (isDone ? "Y" : "N") + "] " + name);
    }
}
