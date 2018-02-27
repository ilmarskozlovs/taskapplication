package businesslogic.userinterface;

import businesslogic.CreateTaskService;
import businesslogic.api.CreateTaskRequest;

import java.util.Scanner;

public class CreateTaskView implements View {

    private CreateTaskService createTaskService;

    public CreateTaskView(CreateTaskService createTaskService) {
        this.createTaskService = createTaskService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Create new Task !");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task name: ");
        String name = sc.nextLine();
        System.out.println("Enter Task description: ");
        String description = sc.nextLine();

        createTaskService.createTaskResponse(new CreateTaskRequest(name,description));

        System.out.println("Create new Task execution end!");
        System.out.println();
    }
}
