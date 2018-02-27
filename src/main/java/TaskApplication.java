import businesslogic.CreateTaskService;
import businesslogic.RemoveAllTasksService;
import businesslogic.RemoveTaskService;
import businesslogic.TaskListService;
import businesslogic.impl.CreateTaskServiceImpl;
import businesslogic.impl.RemoveAllTasksServiceImpl;
import businesslogic.impl.RemoveTaskServiceImpl;
import businesslogic.impl.TaskListServiceImpl;
import businesslogic.userinterface.*;
import database.Database;
import database.InMemoryDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskApplication {

    public static void main(String[] args) {

        Database database = new InMemoryDatabase();

        CreateTaskService createTaskService = new CreateTaskServiceImpl(database);
        RemoveTaskService removeTaskService = new RemoveTaskServiceImpl(database);
        RemoveAllTasksService removeAllTasksService = new RemoveAllTasksServiceImpl(database);
        TaskListService taskListService = new TaskListServiceImpl(database);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, new CreateTaskView(createTaskService));
        commands.put(2, new RemoveTaskView(removeTaskService));
        commands.put(3, new RemoveAllTasksView(removeAllTasksService));
        commands.put(4, new PrintTaskListView(taskListService));


        while (true) {
            printApplicationMenu();
            int menuItem = getFromUserApplicationItemToExecute();
            if (menuItem == 5) {
                break;
            }
            View view = commands.get(menuItem);
            view.execute();
        }
    }


    private static void printApplicationMenu() {
        System.out.println("Application Menu: ");
        System.out.println("1. Create new task");
        System.out.println("2. Remove task from list");
        System.out.println("3. Remove all tasks from list");
        System.out.println("4. Print all tasks to console");
        System.out.println("5. Exit application");
    }

    private static int getFromUserApplicationItemToExecute() {
        System.out.println("Please enter application item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}