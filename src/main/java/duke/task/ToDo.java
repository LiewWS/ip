package duke.task;

/**
 * Represents tasks that are defined as to-dos.
 */
public class ToDo extends Task {
    /**
     * Constructor for creating new ToDO objects.
     * @param name String that contains the name of to-do task to be created.
     */
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return ("[ToDo]" + super.toString());
    }
}
