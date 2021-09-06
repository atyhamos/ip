package duchess.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duchess.main.Duchess;
import duchess.main.DuchessFileHandler;
import duchess.task.ToDo;


public class DeleteCommandTest {
    @Test
    public void testHandleLogic() {
        DuchessFileHandler.clearData();
        Duchess d = new Duchess();
        ToDo t = new ToDo("foo");
        d.getDuchessList().add(t);
        String expectedResponse1 = "Alright. I've removed this task:   \n  " + t
                + "\nNow you have 0 tasks in the list.";
        String expectedResponse2 = "Apologies, that task does not exist and cannot be deleted.";
        assertEquals(new DeleteCommand("1").handleLogic(d), expectedResponse1);
        assertEquals(new DeleteCommand("1").handleLogic(d), expectedResponse2);

    }
}
