package duke;

import duke.Exceptions.DukeException;
import duke.Exceptions.ExceptionType;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Scanner;

public class Storage {
    private String filePath;
    private static final int IS_TYPE = 0;
    private static final int IS_DONE = 1;
    private static final int IS_NAME = 2;
    private static final int IS_TIME = 3;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    private Task createTask(String[] details) {
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
        String[] type = typeAndDone[0].split(" ");
        fields[IS_TYPE] = type[1].replace("[", "");
        fields[IS_DONE] = typeAndDone[IS_DONE].replace("[", "");
        String[] nameAndTime = typeAndDone[2].replace("(", "]").split("]");
        fields[IS_NAME] = nameAndTime[0].trim();
        if (fields[IS_TYPE].equals("Deadline")) {
            String time = nameAndTime[1].split("by:")[1].trim();
            fields[IS_TIME] = time.replace(")", "");
        } else if (fields[IS_TYPE].equals("Event")) {
            String time = nameAndTime[1].split("at:")[1].trim();
            fields[IS_TIME] = time.replace(")", "");
        }

        return fields[IS_TYPE] + " /done " + fields[IS_DONE] + " /name " + fields[IS_NAME]
                + " /time " + fields[IS_TIME];
    }

    public void readFromFile(DukeList dukeList) throws IOException {
        File dataFile = new File(filePath);

        // Check if the directory exists and create directory if it does not exist
        File dataDir = new File(dataFile.getParent());
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }

        Scanner scanner = new Scanner(dataFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] details = line.split(" ");
            dukeList.addTask(createTask(details));
        }
        scanner.close();

        Files.delete(Paths.get(filePath));
    }

    public void writeToFile(DukeList dukeList) throws IOException {
        FileWriter writer = new FileWriter(filePath, true);
        try {
            String[] lines = dukeList.listTasks();
            for (int i = 1; i < lines.length; ++i) {
                // Ignore the first line.
                writer.write(toFileFormat(lines[i]));
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (DukeException dex) {
            if (dex.getExType() != ExceptionType.EMPTY_LIST) {
                System.out.println(dex.getMessage());
            }
        }
    }
}

