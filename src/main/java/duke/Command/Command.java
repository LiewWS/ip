package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public abstract class Command {
    protected CommandType commandType;

    public CommandType getCommandType() {
        return commandType;
    }

    public abstract void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException;
}
