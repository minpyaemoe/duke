package duke.component;

import duke.task.Task;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Ui {

    public static void showWelcomeScreen() {
        String logo = "____        _        \n"
                + "\t |  _ \\ _   _| | _____ \n"
                + "\t | | | | | | | |/ / _ \\\n"
                + "\t | |_| | |_| |   <  __/\n"
                + "\t |____/ \\__,_|_|\\_\\___|\n";

        displayWithFormat(" " + logo + "\n\t Hello! I'm Duke" + "\n" + "\t What can I do for you?");
    }

    public static void showGoodByeScreen() {
        displayWithFormat("Bye. Hope to see you again soon!");
    }

    public static void printDoneAcknowledgement(Task task) {
        displayWithFormat("Nice! I've marked this task as done:"
                + "\n\t   " + task.toString());
    }

    public static void printAddedAcknowledgement(Task task, int taskCount) {
        displayWithFormat("Got it. I've added this task: "
                + "\n\t   " + task.toString()
                + "\n\t Now you have " + taskCount + " tasks in the list.");
    }

    public static void printRemovedAcknowledgement(Task task, int taskCount) {
        displayWithFormat("Noted. I've removed this task:"
                + "\n\t   " + task.toString()
                + "\n\t Now you have "
                + taskCount
                + " tasks in the list.");
    }

    public static void printErrorMessage(Exception e) {
        if(e instanceof FileNotFoundException) {
            printErrorWithFormat("Error: Input Text File not Found! Program Exiting...");
        } else if(e instanceof UnsupportedEncodingException) {
            printErrorWithFormat("Error: Unable to write to file! Program Exiting...");
        } else {
            printErrorWithFormat(e.toString());
        }
    }


    public static void displayWithFormat(String message) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t " + message);
        System.out.println("\t____________________________________________________________");
        System.out.println();
    }

    public static void printErrorWithFormat(String errorMessage) {
        System.err.println("\t____________________________________________________________");
        System.err.println("\t " + errorMessage);
        System.err.println("\t____________________________________________________________");
        System.err.println();
    }

    public static void printTaskList(TaskList taskList) {
        System.out.print("\t____________________________________________________________" +
                "\n\t Here are the tasks in your list:");
        System.out.println(taskList.toString());
        System.out.println("\t____________________________________________________________");
        System.out.println();
    }

    public static void printFoundTaskList(TaskList taskList) {
        System.out.print("\t____________________________________________________________" +
                "\n\t Here are the matching tasks in your list:");
        System.out.println(taskList.toString());
        System.out.println("\t____________________________________________________________");
        System.out.println();
    }
}
