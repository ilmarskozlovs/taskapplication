package businesslogic.userinterface;

import businesslogic.RemoveTaskService;
import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveTaskView implements View{

    @Autowired
    private RemoveTaskService removeTaskService;

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
