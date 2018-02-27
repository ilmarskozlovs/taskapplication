package businesslogic.api;

import domain.Task;

import java.util.List;

public class RemoveAllTasksRequest {

    List<Task> tasks;

    public RemoveAllTasksRequest(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
