package database;

import domain.Task;

import java.util.List;

public interface Database {

    void saveTask(Task task);

    boolean removeTaskByTitle(String name);

    boolean removeAllTasks(List<Task> tasks);

    List<Task> getAllTasks();

}
