package duke;

import duke.Exceptions.DukeException;
import duke.Exceptions.ExceptionType;
import duke.task.Task;

import java.util.ArrayList;

public class DukeList {
    private ArrayList<Task> tasks;

    public DukeList() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Creates a new task and adds it to the list.
     * @param task is the name of task to be added to the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list of tasks.
     * @param serialNum serial number of task as printed when tasks are listed.
     * @return String array to indicate success.
     */
    public String[] deleteTask(int serialNum) {
        int index = serialNum - 1;
        String[] result = {"Task removed:", tasks.get(index).toString(), ""};
        tasks.remove(index);
        result[2] = reportListSize();
        return result;
    }

    /**
     * Creates an array of task names in our list.
     * The first element is a string that serves as a header for the list.
     * Each subsequent element begins with the serial number which is 1 more than the task index.
     * Each subsequent element of the array also has a status field.
     * Y indicates that task is done and N indicates that the task is not done.
     * @return Array of Strings that enumerates the tasks in our list. Null if list empty.
     */
    public String[] listTasks() throws DukeException {
        if (tasks.size() <= 0) {
            throw new DukeException(ExceptionType.EMPTY_LIST);
        }

        String[] result = new String[tasks.size() + 1];
        result[0] = "The following items are tracked:";
        for (int i = 1; i <= tasks.size(); ++i) {
            Task task = tasks.get(i - 1);
            // Format list entry as <serial number>. [<status>] <task name>
            result[i] = i + ". " + task.toString();
        }
        return result;
    }

    /**
     * Mark a task as done by setting isDone attribute to true.
     * @param serialNum serial number of task as printed when tasks are listed.
     * @return String array to indicate success.
     */
    public String[] markAsDone(int serialNum) {
        int index = serialNum - 1;

        Task currentTask = tasks.get(index);
        currentTask.setIsDone();
        return (new String[] {"Nice! You have completed the following item: ",
                "  " + currentTask.toString()});
    }

    /**
     * Reports the number of tasks in the list.
     * @return string that reports the number of tasks in the list.
     */
    public String reportListSize() {
        return ("This list has " + tasks.size() + " task" + ((tasks.size() > 1) ? "s." : "."));
    }
}
