package duke.Command;

import duke.task.ToDo;

import java.io.IOException;

public class TodoCommand extends AddCommand {
    public TodoCommand(String name) {
        task = new ToDo(name);
        commandType = CommandType.CMD_TODO;
    }
}
