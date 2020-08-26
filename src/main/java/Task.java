public class Task {
    private String name;
    private boolean isDone;

    public static int taskCount = 0;

    public Task(String n) {
        this.name = n;
        this.isDone = false;
        taskCount += 1;
    }

    public void setIsDone() {
        this.isDone = true;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public static int getTaskCount() {
        return taskCount;
    }
}
