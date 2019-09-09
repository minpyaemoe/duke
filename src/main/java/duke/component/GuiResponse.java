package duke.component;

import duke.task.Task;

/**
 * A class to provide GUI response messages.
 */
public class GuiResponse {
    public static final String WELCOMEMESSAGE = "\nHello! I'm Duke\n" + "What can I do for you?";
    public static final String GOODBYEMESSAGE = "\nBye. Hope to see you again soon!";

    /**
     * Returns acknowledgement of certain task is changed to status of 'completed' to task list.
     * @param task task whose status is being changed.
     */
    public static String getDoneAcknowledgement(Task task) {
        return "Nice! I've marked this task as done:" + "\n\t" + task.toString();
    }

    /**
     * Returns acknowledgement of certain task is added to the task list and
     * number of items in the task list.
     * @param task being added.
     * @param taskCount number of tasks in the task list.
     */
    public static String getAddedAcknowledgement(Task task, int taskCount) {
        return "Got it. I've added this task: "
                + "\n\t" + task.toString()
                + "\nNow you have " + taskCount + " tasks in the list.";
    }

    /**
     * Returns acknowledgement of certain task is deleted from the task list and
     * number of items in the task list.
     * @param task task to be printed.
     * @param taskCount number of tasks in the task list.
     */
    public static String getRemovedAcknowledgement(Task task, int taskCount) {
        return "Noted. I've removed this task:"
                + "\n\t" + task.toString()
                + "\nNow you have "
                + taskCount
                + " tasks in the list.";
    }

    /**
     * Returns a certain task list with Duke format.
     * @param taskList to be printed on display.
     */
    public static String getTaskListInString(TaskList taskList) {
        return "Here are the tasks in your list:" + "\n" + taskList.toString();
    }

    /**
     * Returns a certain task list with match cases in Duke format.
     * @param taskList to be printed on display.
     */
    public static String getFoundTaskListInString(TaskList taskList) {
        return "\nHere are the matching tasks in your list:" + "\n" + taskList.toString();
    }

    /**
     * Returns unsuccessful undo operation message.
     */
    public static String getUnableToUndoMessage() {
        return "\nSorry! Unable to undo anymore. :(";
    }

    /**
     * Returns an acknowledgment that undo is successful.
     * @param taskList the task list to be printed after successful undo
     */
    public static String getSuccessfulUndoAcknowledgement(TaskList taskList) {
        return "You have just undid your previous action!"
                + "\nHere are the tasks in your list:" + "\n" + taskList.toString();
    }

}
