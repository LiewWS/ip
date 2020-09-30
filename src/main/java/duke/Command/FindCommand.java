package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class FindCommand extends Command {
    private String key;

    public FindCommand(String key) {
        this.key = key;
        commandType = CommandType.CMD_FIND;
    }
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.findTasks(key));
    }
}
