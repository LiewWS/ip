package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents an invalid command provided to program.
 */
public class InvalidCommand extends Command {
    /**
     * Creates a new InvalidCommand object
     */
    public InvalidCommand() {
        commandType = CommandType.CMD_INVALID;
    }

    /**
     * Inform user through ui object that the command supplied was invalid.
     * @param dukeList Not used here.
     * @param ui Ui object for printing message to console.
     * @param store Not used here.
     * @throws IOException Not used here.
     * @throws DukeException Not used here.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOutSingle("Woah hol up! That is not a valid command.");
    }
}
