package duke.command;

import duke.component.GuiResponse;
import duke.component.Storage;
import duke.component.TaskList;
import duke.component.Ui;
import duke.task.Task;

import java.util.List;

/**
 * Command Class for looking for match cases in the task list.
 */
public class FindCommand extends Command {

    private String keyword;

    /**
     * Constructor for FindCommand Object.
     * @param keyword to search for inside the task list later on.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the operation of looking for keyword matches inside the task list.
     * @param taskList list of tasks.
     * @param storage storage to store inside hard disk.
     * @param ui ui for user interaction.
     * @param historicalTaskLists storage for previous version of Task List for undo
     * @return boolean indication of successful or unsuccessful running of command.
     */
    @Override
    public String executeCommand(TaskList taskList, Storage storage, Ui ui, List<TaskList> historicalTaskLists) {
        TaskList tempTaskList = new TaskList();

        assert (!keyword.equals("")) : "Search keyword should not be an empty string.";

        for (int i = 0; i < taskList.getSize(); i++) {
            Task t = taskList.getAtIndex(i);
            if (t.getDescription().contains(keyword)) {
                tempTaskList.add(t);
            }
        }

        return GuiResponse.getFoundTaskListInString(tempTaskList);
    }

}
