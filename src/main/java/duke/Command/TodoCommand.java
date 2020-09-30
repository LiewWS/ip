package duke.Command;

import duke.task.ToDo;

/**
 * Represents the command to add a ToDo to the list.
 */
public class TodoCommand extends AddCommand {
    /**
     * Constructor for creating a new TodoCommand
     * @param name String that holds the name of the to-do task to be created.
     */
    public TodoCommand(String name) {
        task = new ToDo(name);
        commandType = CommandType.CMD_TODO;
    }
}
