package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the command to find tasks in the list.
 */
public class FindCommand extends Command {
    private String key;

    /**
     * Constructor for the FindCommand object.
     * @param key String to be searched for in the names of the tasks.
     */
    public FindCommand(String key) {
        this.key = key;
        commandType = CommandType.CMD_FIND;
    }

    /**
     * Execute the command to find the key in the tasks.
     * @param dukeList DukeList to be searched.
     * @param ui Ui object to display search results in console.
     * @param store Not used here.
     * @throws IOException Not used here.
     * @throws DukeException if the list is empty or the item is not in the list.
     */
    @Override
    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        ui.printOut(dukeList.findTasks(key));
    }
}
