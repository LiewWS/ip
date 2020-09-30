package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import duke.task.Task;

import java.io.IOException;

/**
 * Represents commands to add a task to the list.
 */
public abstract class AddCommand extends Command {
    protected Task task;

    /**
     * Method to execute the command to add a task to the list.
     * @param dukeList DukeList where the task should be added to.
     * @param ui Ui object for printing output to console.
     * @param store Storage object that represents the data file for storage. Not used here.
     * @throws IOException Not used here.
     * @throws DukeException Not used here.
     */
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        dukeList.addTask(task);
        ui.printOut(new String[] {"Task added: ", task.toString(), dukeList.reportListSize()});
    }
}
