package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class InvalidCommand extends Command {
    public InvalidCommand() {
        commandType = CommandType.CMD_INVALID;
    }

    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOutSingle("Woah hol up! That is not a valid command.");
    }
}
