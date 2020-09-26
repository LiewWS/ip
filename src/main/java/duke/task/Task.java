package duke.task;

public abstract class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        isDone = false;
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
        return ("[" + (isDone ? "Y" : "N") + "] " + name);
    }
}
