import java.util.ArrayList;

public class DukeList {
    private ArrayList<Task> tasks;

    public DukeList() {
        this.tasks = new ArrayList();
    }

    /**
     * Adds a String to our list and increments the size of our list.
     * @param item String to be added to the list.
     */
    public void addItem(String item) {
        Task task = new Task(item);
        this.tasks.add(task);
    }

    /**
     * Creates an array of items in our list.
     * The first element is a string that serves as a header for the list.
     * Each subsequent element begins with the serial number which is 1 more than the item index.
     * Each subsequent element of the array also has a status field.
     * ✓ indicates that task is done and ✗ indicates that the task is not done.
     * @return Array of Strings that enumerates the items in our list. Null if list empty.
     */
    public String[] listItems() {
        if (Task.getTaskCount() > 0) {
            String[] result = new String[Task.getTaskCount() + 1];

            result[0] = "The following items are tracked:";
            for (int i = 1; i <= Task.getTaskCount(); ++i) {
                Task task = tasks.get(i - 1);
                result[i] = i + ". [" + (task.checkDone() ? "✓" : "✗") + "] " + task.getName();
            }

            return result;
        }
        else {
            return null;
        }
    }

    /**
     * Mark an item as done by setting corresponding element in isDOne to true.
     * @param serialNum serial number of item as printed when items are listed.
     * @return String to indicate success. Null if index out of bounds.
     */
    public String markAsDone(int serialNum) {
        int index = serialNum - 1;
        if (index < Task.getTaskCount()) {
            Task currentTask = tasks.get(index);
            currentTask.completeTask();
            return ("  [✓] " + currentTask.getName());
        }
        else {
            return null;
        }
    }
}
