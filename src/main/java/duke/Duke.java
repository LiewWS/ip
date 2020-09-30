package duke;

import duke.Command.Command;
import duke.Command.CommandType;
import duke.Exceptions.DukeException;

import java.io.IOException;

/**
 * Represents the main Duke program.
 */
public class Duke {
    private static final String DATA_FILE_PATH = "data/list_data.txt";
    private Ui ui;
    private DukeList dukeList;
    private Storage store;

    /**
     * Constructor for creating a Duke object.
     * @param filePath String that identifies the relative path from current directory to the file
     *                 that stores data provided by the user to Duke.
     */
    public Duke(String filePath) {
        ui = new Ui();
        store = new Storage(filePath);
        dukeList = new DukeList();
        try {
            store.readFromFile(dukeList);
        } catch (IOException ex) {
            ui.printOutSingle(ex.getMessage());
        }
    }

    /**
     * Entry point of the Duke program.
     * @param args List of arguments that can be provided to the program.
     *             Will be ignored if supplied.
     */
    public static void main(String[] args) {
       new Duke(DATA_FILE_PATH).run();
    }

    public void run() {
        ui.greet();

        while (true) {
            try {
                Command cmd = Parser.parseRaw(ui.readLine());
                cmd.executeCommand(dukeList, ui, store);
                if (cmd.getCommandType() == CommandType.CMD_EXIT) {
                    break;
                }
            } catch (DukeException | IOException | NumberFormatException ex) {
                ui.printOutSingle(ex.getMessage());
            }
        }
    }

    /**
     * System.out.println(getLogo()) prints the logo.
     * @return String that can be printed directly to print the logo.
     */
    public static String getLogo() {
        return ("____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
    }
}
