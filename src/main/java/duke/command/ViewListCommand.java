package duke.command;

import duke.component.GuiResponse;
import duke.component.Storage;
import duke.component.TaskList;
import duke.component.Ui;

import java.util.List;

/**
 * Command Class for view the task list.
 */
public class ViewListCommand extends Command {

    /**
     * Executes the operation of displaying task list.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
     * @return boolean indication of successful or unsuccessful running of command.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists) {

        assert taskList != null : "A Task List which is going to be displayed should not be a null object.";

        assert taskList != null : "A Task List which is going to be displayed should not be a null object.";

        return GuiResponse.getTaskListInString(taskList);
    }
}
