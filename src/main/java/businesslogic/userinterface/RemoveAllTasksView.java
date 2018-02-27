package businesslogic.userinterface;

import businesslogic.RemoveAllTasksService;

public class RemoveAllTasksView implements View {

    private RemoveAllTasksService removeAllTasksService;

    public RemoveAllTasksView(RemoveAllTasksService removeAllTasksService) {
        this.removeAllTasksService = removeAllTasksService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove all tasks !");

//        boolean response = removeAllTasksResponse.isRemoved();

        System.out.println("All tasks has been removed!");
        System.out.println();
    }
}
