import businesslogic.userinterface.*;
import configs.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, applicationContext.getBean(CreateTaskView.class));
        commands.put(2, applicationContext.getBean(PrintTaskListView.class));
        commands.put(3, applicationContext.getBean(RemoveTaskView.class));
        commands.put(4, applicationContext.getBean(RemoveAllTasksView.class));


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