package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.*;

/**
 * Command to delete task from list
 *
 * @author Lian Zhi Xuan
 */
public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int i) {
        index = i;
    }

    /**
     * Deletes selected task from TaskList.
     *
     * @param list TaskList to be modified.
     * @return prompt for deleting task.
     */
    @Override
    public String execute(TaskList list) {
        Task temp = list.getList().get(index);
        list.delete(index);
        Storage.instance.save(list);
        return Ui.instance.deletePrompt(temp);
    }

    public int index() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DeleteCommand) {
            DeleteCommand temp = (DeleteCommand) o;
            return this.index == ((DeleteCommand) o).index();
        }
        return false;
    }
}
