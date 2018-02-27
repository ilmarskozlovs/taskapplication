import domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TaskApplication {

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        while (true){
            printApplicationMenu();
            int menuItem = getFromUserApplicationItemToExecute();
            if (menuItem == 5){
                break;
            }
            switch (menuItem){
                case 1: {
                    createNewTask(tasks);
                    break;
                }
                case 2: {
                    removeTask(tasks);
                    break;
                }
                case 3:{
                    removeAllTasks(tasks);
                    break;
                }
                case 4:{
                    printTaskList(tasks);
                    break;
                }
            }
        }

    }

    private static void printApplicationMenu(){
        System.out.println("Application Menu: ");
        System.out.println("1. Create new task");
        System.out.println("2. Remove task from list");
        System.out.println("3. Remove all tasks from list");
        System.out.println("4. Print all tasks to console");
        System.out.println("5. Exit application");
    }

    private static int getFromUserApplicationItemToExecute(){
        System.out.println("Please enter application item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void createNewTask(List<Task> tasks){
        System.out.println();
        System.out.println("Create new Task !");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task name: ");
        String name = sc.nextLine();
        System.out.println("Enter Task description: ");
        String description = sc.nextLine();
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        tasks.add(task);
        System.out.println("Create new Task execution end!");
        System.out.println();
    }

    private static void removeTask(List<Task> tasks){
        System.out.println();
        System.out.println("Remove existing Task !");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task to delete");
        final String name = sc.nextLine();
        Optional<Task> foundTask = tasks.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
        if (foundTask.isPresent()){
            System.out.println("Task with name " + name + "found, and will be removed from list!");
            Task task = foundTask.get();
            tasks.remove(task);
        }
        else {
            System.out.println("Task with name " + name + "was not found, and will not be removed from list!");
        }
        System.out.println("Remove existing task execution end!");
    }

    private static void removeAllTasks(List<Task> tasks){
        System.out.println();
        System.out.println("Remove all tasks !");
        tasks.clear();
        System.out.println("Remove all tasks execution end!");
        System.out.println();
    }
    private static void printTaskList(List<Task> tasks){
        System.out.println();
        System.out.println("Print task list to console !");
        for (Task t: tasks) {
            System.out.println(t.getName() + t.getDescription() + "]");
        }
        System.out.println("Print task list to console execution end!");
        System.out.println();
    }
}
