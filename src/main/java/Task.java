public class Task {
    private String name;
    private boolean isDone;

    private static int taskCount = 0;

    public Task(String name) {
        this.name = name;
        isDone = false;
        taskCount += 1;
    }

    public void setIsDone() {
        isDone = true;
    }

    public String getName() {
        return name;
    }

    public boolean getIsDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "Done" : "Not done") + "] " + name;
    }

    public static int getTaskCount() {
        return taskCount;
    }
}
