package businesslogic.userinterface;

import businesslogic.TaskListService;
import businesslogic.api.TaskListResponse;
import domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTaskListView implements View {

    @Autowired
    private TaskListService taskListService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print task list to console !");

        TaskListResponse response = taskListService.getTasks();

        for (Task t: response.getTasks()) {
            System.out.println(t.getName() + t.getDescription() + "]");
        }
        System.out.println("Print task list to console execution end!");
        System.out.println();
    }
}
