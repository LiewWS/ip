package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {
    private static final String DATA_FILE_NAME = "../../../data/list_data.txt";
    private static final int IS_TYPE = 0;
    private static final int IS_DONE = 1;
    private static final int IS_NAME = 2;
    private static final int IS_TIME = 3;

    private static Task createTask(String[] details) {
        Task currentTask = null;
        boolean[] flags = {true, false, false, false};
        String[] fields = {"", "", "", ""};

        for (String detail : details) {
            if (detail.equals("/done")) {
                flags[IS_TYPE] = false;
                flags[IS_DONE] = true;
            } else if (detail.equals("/name")) {
                flags[IS_DONE] = false;
                flags[IS_NAME] = true;
            } else if (detail.equals("/time")) {
                flags[IS_NAME] = false;
                flags[IS_TIME] = true;
            } else if (flags[IS_TYPE]) {
                fields[IS_TYPE] += detail;
            } else if (flags[IS_DONE]) {
                fields[IS_DONE] += detail;
            } else if (flags[IS_NAME]) {
                fields[IS_NAME] += detail + " ";
            } else {
                fields[IS_TIME] += detail + " ";
            }
        }

        if (fields[IS_TYPE].equals("ToDo")) {
            currentTask = new ToDo(fields[IS_NAME]);
        } else if (fields[IS_TYPE].equals("Deadline")) {
            currentTask = new Deadline(fields[IS_NAME], fields[IS_TIME]);
        } else if (fields[IS_TYPE].equals("Event")) {
            currentTask = new Event(fields[IS_NAME], fields[IS_TIME]);
        }
        assert currentTask != null;
        if (fields[IS_DONE].equals("Y")) {
            currentTask.setIsDone();
        }
        return currentTask;
    }

    private static String toFileFormat(String line) {
        String[] fields = {"", "", "", ""};
        String result = "";

        String[] typeAndDone = line.split("]");
        fields[IS_TYPE] = typeAndDone[IS_TYPE].replace("[", "");
        fields[IS_DONE] = typeAndDone[IS_DONE].replace("[", "");
        String[] nameAndTime = typeAndDone[2].replace("(", "]").split("]");
        fields[IS_NAME] = nameAndTime[0].trim();
        if (fields[IS_TYPE].equals("Deadline")) {
            nameAndTime[1].replace("by:", "");
            fields[IS_TIME] = nameAndTime[1].trim();
        } else if (fields[IS_TYPE].equals("Deadline")) {
            nameAndTime[1].replace("at:", "");
            fields[IS_TIME] = nameAndTime[1].trim();
        }

        return fields[IS_TYPE] + " /done " + fields[IS_DONE] + " /name " + fields[IS_NAME]
                + " /time " + fields[IS_TIME];
    }

    public static void readFromFile(DukeList dukeList) throws IOException {
        File dataFile = new File(DATA_FILE_NAME);
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        Scanner scanner = new Scanner(Paths.get(DATA_FILE_NAME));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] details = line.split(" ");
            dukeList.addTask(createTask(details));
        }
    }

    public static void writeToFile(DukeList dukeList) throws IOException, DukeException {
        PrintWriter writer = new PrintWriter(DATA_FILE_NAME);
        String[] lines = dukeList.listTasks();

        for (String line : lines) {
            writer.println(toFileFormat(line));
        }
    }
}
