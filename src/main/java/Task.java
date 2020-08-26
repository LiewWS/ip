public class Task {
    private String name;
    private boolean isDone;

    public static int taskCount = 0;

    public Task(String n) {
        this.name = n;
        this.isDone = false;
        taskCount += 1;
    }

    /**
     * Record that the task is done.
     */
    public void completeTask() {
        this.isDone = true;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Check if the task is done.
     * @return true if task is done, otherwise false.
     */
    public boolean checkDone() {
        return this.isDone;
    }

    public static int getTaskCount() {
        return taskCount;
    }
}
