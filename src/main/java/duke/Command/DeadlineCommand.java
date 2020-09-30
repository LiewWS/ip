package duke.Command;

import duke.task.Deadline;

/**
 * Represents the command to add a deadline to the list.
 */
public class DeadlineCommand extends AddCommand {
    /**
     * Constructor for creating a new DeadlineCommand
     * @param name String that holds the name of the deadline task to be created.
     * @param time String that holds the time that the task must be completed by.
     */
    public DeadlineCommand(String name, String time) {
        task = new Deadline(name, time);
        commandType = CommandType.CMD_DEADLINE;
    }

}
