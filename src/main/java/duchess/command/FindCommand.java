package duchess.command;

import duchess.main.Duchess;
import duchess.task.Task;

public class FindCommand extends Command {

    public FindCommand(String name) {
        super(name);
    }

    /**
     * Handles the logic for finding tasks containing a keyword.
     * @param duchess The Duchess to return the output to.
     * @return The tasks which match the condition input.
     */
    public String handleLogic(Duchess duchess) {
        String invalidMessage = "There are no tasks with that keyword.";
        String keyword = getName();
        String reply;
        String results = "";
        int counter = 0;
        for (int i = 0; i < duchess.getDuchessList().getSize(); i++) {
            Task t = duchess.getDuchessList().getTask(i + 1);
            if (t.contains(keyword)) {
                results += String.format("%d. %s\n", ++counter, t);
            }
        }
        if (results.isEmpty()) {
            reply = invalidMessage;
        } else {
            reply = results;
        }
        assert !reply.isBlank() : "Reply should not be empty.";
        return reply;
    }
}
