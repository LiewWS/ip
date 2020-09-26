package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class ListCommand extends Command {
    public ListCommand() {
        commandType = CommandType.CMD_LIST;
    }

    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.listTasks());
    }
}
