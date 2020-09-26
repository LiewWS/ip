package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        commandType = CommandType.CMD_DONE;
        this.index = index;
    }

    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.markAsDone(index));
    }
}
