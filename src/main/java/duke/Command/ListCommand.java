package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the command to display the list of tasks.
 */
public class ListCommand extends Command {
    /**
     * Constructor for creating a ListCommand object.
     */
    public ListCommand() {
        commandType = CommandType.CMD_LIST;
    }

    /**
     * Method to execute the command to display the list of tasks on the console.
     * @param dukeList DukeList where tasks to be displayed are stored.
     * @param ui Ui object for writing output to console.
     * @param store Not used here.
     * @throws IOException Not used here.
     * @throws DukeException if list is empty.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.listTasks());
    }
}
