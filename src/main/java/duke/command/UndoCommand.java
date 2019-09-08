package duke.command;

import duke.component.GuiResponse;
import duke.component.Storage;
import duke.component.TaskList;
import duke.component.Ui;
import duke.task.Task;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Command Class for view the task list.
 */
public class UndoCommand extends Command {

    /**
     * Executes the operation of displaying task list.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
     * @return boolean indication of successful or unsuccessful running of command.
     * @throws FileNotFoundException when textfile cannot be found.
     * @throws UnsupportedEncodingException when error occurs while writing to hard disk.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists)
            throws FileNotFoundException, UnsupportedEncodingException {
        if (historicalTaskLists.size() > 0) {
            taskList.replaceAll(historicalTaskLists.remove(historicalTaskLists.size() - 1));
            storage.save(taskList);
            return GuiResponse.getSuccessfulUndoAcknowledgement(taskList);
        } else {
            return GuiResponse.getUnableToUndoMessage();
        }


    }
}