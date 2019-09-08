package duke.command;

import duke.component.GuiResponse;
import duke.component.Storage;
import duke.component.TaskList;
import duke.component.Ui;

import java.io.IOException;
import java.util.List;

/**
 * Command Class for exiting the program.
 */
public class ExitCommand extends Command {

    /**
     * Executes the operation of exiting Duke program.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
     * @return boolean indication of successful or unsuccessful running of command.
     * @throws IOException when error occurs while writing to hard disk.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists)
            throws IOException {

        storage.save(taskList);
        return GuiResponse.GOODBYEMESSAGE;
    }
}
