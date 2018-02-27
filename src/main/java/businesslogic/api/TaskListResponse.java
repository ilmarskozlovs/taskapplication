package businesslogic.api;

import domain.Task;

import java.util.List;

public class TaskListResponse {

    private List<Task> tasks;

    public TaskListResponse(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
