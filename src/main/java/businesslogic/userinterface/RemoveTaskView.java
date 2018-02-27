package businesslogic.userinterface;

import businesslogic.RemoveTaskService;
import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;

import java.util.Scanner;

public class RemoveTaskView implements View{

    private RemoveTaskService removeTaskService;

    public RemoveTaskView(RemoveTaskService removeTaskService) {
        this.removeTaskService = removeTaskService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove existing Task !");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task to delete");
        final String name = sc.nextLine();

        RemoveTaskResponse response = removeTaskService.removeByTitle(new RemoveTaskRequest(name));

        if (response.isRemoved()){
            System.out.println("Task with name " + name + "found, and will be removed from list!");

        }
        else {
            System.out.println("Task with name " + name + "was not found, and will not be removed from list!");
        }
        System.out.println("Remove existing task execution end!");
    }
}
