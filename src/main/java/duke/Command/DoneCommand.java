package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the command to mark an item in the list as done.
 */
public class DoneCommand extends Command {
    private int serialNum;

    /**
     * Constructor to create a new DoneCommand object to mark item at serialNum as done.
     * @param serialNum serial number of task as printed when tasks are listed.
     */
    public DoneCommand(int serialNum) {
        commandType = CommandType.CMD_DONE;
        this.serialNum = serialNum;
    }

    /**
     * Method to execute to mark a task as done
     * @param dukeList DukeList where task to be marked as done is located.
     * @param ui Ui object for printing result of execution to console.
     * @param store Storage object representing file where data is stored. Not used here.
     * @throws IOException Not used here.
     * @throws DukeException if serialNum is invalid.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.markAsDone(serialNum));
    }
}
