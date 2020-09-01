public class Event extends Task {
    private String timeSlot;

    public Event(String name, String timeSlot) {
        super(name);
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "[Event]" + super.toString() + " (at: " + timeSlot + ")";
    }
}
