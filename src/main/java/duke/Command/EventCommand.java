package duke.Command;

import duke.task.Event;

import java.io.IOException;

public class EventCommand extends AddCommand {
    public EventCommand(String name, String time) {
        task = new Event(name, time);
    }
}
