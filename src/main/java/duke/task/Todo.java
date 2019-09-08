package duke.task;

public class Todo extends Task {

    /**
     * Constructor for Todo object with default done status.
     * @param description the description of the task.
     */
    public Todo(String description) {
        super(description, false);
    }

    /**
     * Constructor for Todo object with certain done status.
     * @param description the description of the task.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Changes the status of the Todo to 'completed'.
     * @return a new Todo object with 'completed' status.
     */
    @Override
    public Todo changeToCompletedStatus() {
        return new Todo(super.description, true);
    }

    /**
     * Returns formatted and user readable form of the task.
     * @return formatted and user readable form of the task in String.
     */
    @Override
    public String toString() {
        String s = "";
        if (isDone) {
            s = s + "[T][O]";
        } else {
            s = s + "[T][ ]";
        }

        return s + " " + description;
    }

    /**
     * Returns formatted form of the task to be stored in inside a text file.
     * @return formatted form of the task to be stored in inside a text file.
     */
    public String toIndicationInsideFile() {
        String s = "T | ";

        if (isDone) {
            s = s + "1 | ";
        } else {
            s = s + "0 | ";
        }

        return s + description;
    }
}
