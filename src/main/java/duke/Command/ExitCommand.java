package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class ExitCommand extends Command {
    public ExitCommand() {
        commandType = CommandType.CMD_EXIT;
    }

    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        store.writeToFile(dukeList);
        ui.printOutSingle("Bye. Hope to see you again soon!");
    }
}
