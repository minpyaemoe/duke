public class Task {
    protected String name;
    protected boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    protected Task(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public Task changeToCompletedStatus() {
        return new Task(this.name, true);
    }

    public String getName() {
        return name;
    }

    public void setDone() {
        this.done = true;
    }

    public String toIndicationInsideFile() {
        String s = "T | ";

        if(done) {
            s = s + "1 | ";
        } else {
            s = s + "1 | ";
        }

        return s + name;
    }
}