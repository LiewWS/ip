package duke.Command;

import duke.task.Deadline;

public class DeadlineCommand extends AddCommand {
    public DeadlineCommand(String name, String time) {
        task = new Deadline(name, time);
        commandType = CommandType.CMD_DEADLINE;
    }

}
