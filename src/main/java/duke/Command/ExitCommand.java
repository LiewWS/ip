package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the command to exit from the program.
 */
public class ExitCommand extends Command {
    /**
     * Constructor to create a new ExitCommand object.
     */
    public ExitCommand() {
        commandType = CommandType.CMD_EXIT;
    }

    /**
     * Method to execute to save data and exit from program.
     * @param dukeList DukeList containing data to be saved.
     * @param ui Ui object for printing result of execution to console.
     * @param store Storage object representing file where data is saved to.
     * @throws IOException if file I/O operation fails
     * @throws DukeException Not used here.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        store.writeToFile(dukeList);
        ui.bidFarewell();
    }
}
