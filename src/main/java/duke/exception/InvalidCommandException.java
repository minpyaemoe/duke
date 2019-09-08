package duke.exception;

/**
 * Exception Class for Duke error.
 */
public class InvalidCommandException extends DukeException {

    /**
     * Constructor for InvalidCommandException Object.
     * @param message Message of the error.
     */
    public InvalidCommandException(String message) {
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
