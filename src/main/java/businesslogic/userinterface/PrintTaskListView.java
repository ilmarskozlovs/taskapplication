package businesslogic.userinterface;

import businesslogic.TaskListService;
import businesslogic.api.TaskListResponse;
import domain.Task;

public class PrintTaskListView implements View {

    private TaskListService taskListService;

    public PrintTaskListView(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

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
