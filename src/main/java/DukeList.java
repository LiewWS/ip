import java.util.ArrayList;

public class DukeList {
    private ArrayList<String> items;
    private ArrayList<Boolean> isDone;
    private int listSize;

    public DukeList() {
        this.items = new ArrayList();
        this.isDone = new ArrayList();
        listSize = 0;
    }

    /**
     * Adds a String to our list and increments the size of our list.
     * @param item String to be added to the list.
     */
    public void addItem(String item) {
        this.items.add(item);
        this.isDone.add(false);
        ++(this.listSize);
    }

    /**
     * Creates an array of items in our list.
     * Each element begins with the serial number which is 1 more than the item index
     * Each list element of the array also has a status field.
     * ✓ indicates that task is done and ✗ indicates that the task is not done.
     * @return Array of Strings that enumerates the items in our list. Null if list empty
     */
    public String[] listItems() {
        if (this.listSize > 0) {
            String[] result = new String[this.listSize];

            for (int i = 0; i < this.listSize; ++i) {
                result[i] = (i + 1) + ". [" + (this.isDone.get(i) ? "✓" : "✗") + "] " + items.get(i);
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
        if (index < this.listSize) {
            this.isDone.set(index, true);
            return ("  [✓] " + this.items.get(index));
        }
        else {
            return null;
        }
    }
}
