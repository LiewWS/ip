import java.util.ArrayList;

public class DukeList {
    private ArrayList<String> items;
    private int listSize;

    public DukeList() {
        this.items = new ArrayList();
        listSize = 0;
    }

    /**
     * Adds a String to our list and increments the size of our list.
     * @param item String to be added to the list.
     */
    public void addItem(String item) {
        this.items.add(item);
        ++(this.listSize);
    }

    /**
     * Creates an array enumerating the items in our list.
     * @return Array of Strings that enumerates the items in our list.
     */
    public String[] listItems() {
        if (this.listSize > 0) {
            String[] result = new String[this.listSize];
            int i = 0;

            for (String item : items) {
                result[i] = (i + 1) + ". " + item;
                ++i;
            }

            return result;
        }
        else {
            return null;
        }
    }
}
