package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime deadLine;

    /**
     * Constructor for Deadline object with default done status.
     * @param description the description of the task.
     * @param deadLine the deadline in date and time format.
     */
    public Deadline(String description, LocalDateTime deadLine) {
        super(description, false);
        this.deadLine = deadLine;
    }

    /**
     * Constructor for Deadline object with certain done status.
     * @param description the description of the task.
     * @param deadLine the deadline in date and time format.
     */
    public Deadline(String description, LocalDateTime deadLine, boolean isDone) {
        super(description, isDone);
        this.deadLine = deadLine;
    }

    /**
     * Changes the status of the deadline to 'completed'.
     * @return a new deadline object with 'completed' status.
     */
    @Override
    public Deadline changeToCompletedStatus() {
        return new Deadline(super.description, this.deadLine, true);
    }

    /**
     * Returns formatted and user readable form of the task.
     * @return formatted and user readable form of the task in String.
     */
    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, E, h:mm a");
        String s = "";
        if (isDone) {
            s = s + "[D][O]";
        } else {
            s = s + "[D][ ]";
        }

        return s + " " + description + " (by: " + deadLine.format(formatter) + ")";
    }

    /**
     * Returns formatted form of the task to be stored in inside a text file.
     * @return formatted form of the task to be stored in inside a text file.
     */
    public String toIndicationInsideFile() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s = "D | ";

        if (isDone) {
            s = s + "1 | ";
        } else {
            s = s + "0 | ";
        }

        return s + description + " | " + deadLine.format(formatter) + " "
                + (deadLine.getHour() * 100 + deadLine.getMinute());
    }
}