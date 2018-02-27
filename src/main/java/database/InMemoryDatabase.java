package database;

import domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database{

    private List<Task> tasks = new ArrayList<>();

    @Override
    public void saveTask(Task task) {
        tasks.add(task);
    }

    @Override
    public boolean removeTaskByTitle(String name) {
        Optional<Task> foundTask = tasks.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
        if (foundTask.isPresent()){
            Task task = foundTask.get();
            tasks.remove(task);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAllTasks(List<Task> tasks) {
        this.tasks.clear();
        return false;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> cloned = new ArrayList<>();
        cloned.addAll(tasks);
        return cloned;
    }
}
