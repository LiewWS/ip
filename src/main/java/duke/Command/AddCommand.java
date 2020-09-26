package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import duke.task.Task;

import java.io.IOException;

public abstract class AddCommand extends Command {
    protected Task task;

    public void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException {
        dukeList.addTask(task);
        ui.printOut(new String[] {"Task added: ", task.toString(), dukeList.reportListSize()});
    }
}
