import duke.command.Command;
import duke.command.ExitCommand;
import duke.component.Storage;
import duke.component.Ui;
import duke.component.TaskList;
import duke.component.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private List<TaskList> historicalTaskLists;

    /**
     * Constructor for Duke Object.
     * @throws FileNotFoundException while input text file cannot be found.
     * @throws IOException while input text file cannot be created.
     */
    public Duke() {
        try {
            ui = new Ui();
            storage = new Storage(System.getProperty("user.dir"));
            ui.showWelcomeScreen();
            taskList = new TaskList(storage.load());
            historicalTaskLists = new ArrayList<>();
        } catch (Exception e) {
            Ui.printErrorMessage(e);
            return;
        }
    }


    /**
     * Runs Duke Program for Console.
     */
    public void run() {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            try {
                Command newCommand = Parser.retrieveCommandFromString(sc.nextLine());
                newCommand.executeCommand(taskList, storage, ui, historicalTaskLists);
                if (newCommand instanceof ExitCommand) {
                    return;
                }
            } catch (Exception e) {
                ui.printErrorMessage(e);
            }
        }
    }


    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.retrieveCommandFromString(input);
            return command.executeCommand(taskList, storage, ui, historicalTaskLists);
        } catch (Exception e) {
            return e.toString();
        }
    }
}