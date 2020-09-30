package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the command to delete an item from the list.
 */
public class DeleteCommand extends Command {
    private int serialNum;

    /**
     * Constructor to create a new DeleteCommand object to delete item at serialNum.
     * @param serialNum serial number of task as printed when tasks are listed.
     */
    public DeleteCommand(int serialNum) {
        commandType = CommandType.CMD_DELETE;
        this.serialNum = serialNum;
    }

    /**
     * Method to execute the command to delete an item from the list
     * @param dukeList DukeList where the item to be deleted is located.
     * @param ui Ui object for printing result of execution to console.
     * @param store Storage object representing file where data is stored. Not used here.
     * @throws IOException Not used here.
     * @throws DukeException  If serialNum is not in valid range.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.deleteTask(serialNum));
    }
}
