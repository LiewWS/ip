public class Deadline extends Task {
    private String dateTime;

    public Deadline(String name, String dateTime) {
        super(name);
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "[Deadline]" + super.toString() + " (by: " + dateTime + ")";
    }
}
