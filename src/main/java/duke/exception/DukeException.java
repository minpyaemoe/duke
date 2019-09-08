package duke.exception;

/**
 * Exception Class for Duke error.
 */
public class DukeException extends Exception {

    /**
     * Constructor for DukeException Object.
     * @param message Message of the error.
     */
    public DukeException(String message) {
        super(message);
    }

    /**
     * Returns formatted and user-readable form of error.
     * @return formatted and user-readable form of error in String format.
     */
    @Override
    public String toString() {
        return "OOPS!!! " + getMessage();
    }
}
