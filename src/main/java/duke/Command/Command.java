package duke.Command;

import duke.DukeList;
import duke.Exceptions.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

/**
 * Represents the commands that users can instruct the program to execute.
 */
public abstract class Command {
    protected CommandType commandType;

    /**
     * Getter method fpr retrieving information of the command type.
     * @return CommandType that represents the type of command.
     */
    public CommandType getCommandType() {
        return commandType;
    }

    public abstract void executeCommand(DukeList dukeList, Ui ui, Storage store) throws IOException, DukeException;
}
