package duke;

import duke.Command.Command;
import duke.Command.CommandType;
import duke.Exceptions.DukeException;

import java.io.IOException;

public class Duke {
    private static final String DATA_FILE_PATH = "data/list_data.txt";
    private static final String[] GREETING = {getLogo(), "Hello, I am Duke", "What can I do for you?"};
    private Ui ui;
    private DukeList dukeList;
    private Storage store;

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

    public static void main(String[] args) {
       new Duke(DATA_FILE_PATH).run();
    }

    public void run() {
        ui.printOut(GREETING);

        while (true) {
            try {
                Command cmd = Parser.parseRaw(ui.readLine());
                cmd.executeCommand(dukeList, ui, store);
                if (cmd.getCommandType() == CommandType.CMD_EXIT) {
                    break;
                }
            } catch (DukeException | IndexOutOfBoundsException | IOException ex) {
                ui.printOutSingle(ex.getMessage());
            }
        }
    }

    /**
     * System.out.println(getLogo()) prints the logo.
     * @return String that can be printed directly to print the logo.
     */
    private static String getLogo() {
        return ("____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n");
    }
}
