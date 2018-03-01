package businesslogic.userinterface;

import businesslogic.RemoveAllTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveAllTasksView implements View {

    @Autowired
    private RemoveAllTasksService removeAllTasksService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove all tasks !");

//        boolean response = removeAllTasksResponse.isRemoved();

        System.out.println("All tasks has been removed!");
        System.out.println();
    }
}
