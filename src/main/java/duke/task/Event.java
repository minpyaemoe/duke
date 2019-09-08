package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime time;

    /**
     * Constructor for Event Object with default done status.
     * @param description the description of the event.
     * @param time the time of the event.
     */
    public Event(String description, LocalDateTime time) {
        super(description, false);
        this.time = time;
    }

    /**
     * Constructor for Event Object with certain done status.
     * @param description the description of the event.
     * @param time  the time of the event.
     * @param isDone the status of the event.
     */
    public Event(String description, LocalDateTime time, boolean isDone) {
        super(description, isDone);
        this.time = time;
    }


    /**
     * Changes the status of the event to 'completed'.
     * @return a new event object with 'completed' status.
     */
    @Override
    public Event changeToCompletedStatus() {
        return new Event(super.description, this.time, true);
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
            s = s + "[E][O]";
        } else {
            s = s + "[E][ ]";
        }

        return s + " " + description + " (at: " + time.format(formatter) + ")";
    }


    /**
     * Returns formatted form of the task to be stored in inside a text file.
     * @return formatted form of the task to be stored in inside a text file.
     */
    public String toIndicationInsideFile() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s = "E | ";

        if (isDone) {
            s = s + "1 | ";
        } else {
            s = s + "0 | ";
        }

        return s + description + " | " + time.format(formatter)
                + " " + (time.getHour() * 100 + time.getMinute());
    }
}