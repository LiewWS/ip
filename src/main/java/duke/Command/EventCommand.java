package duke.Command;

import duke.task.Event;

/**
 * Represents the command to add an event to the list.
 */
public class EventCommand extends AddCommand {
    /**
     * Constructor for creating a new EventCommand
     * @param name String that holds the name of the event task to be created.
     * @param time String that holds the time that the event occurs.
     */
    public EventCommand(String name, String time) {
        task = new Event(name, time);
        commandType = CommandType.CMD_EVENT;
    }
}
