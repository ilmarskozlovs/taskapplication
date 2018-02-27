package businesslogic.impl;

import database.Database;
import businesslogic.CreateTaskService;
import businesslogic.api.CreateTaskRequest;
import businesslogic.api.CreateTaskResponse;
import domain.Task;

public class CreateTaskServiceImpl implements CreateTaskService {

    private Database database;

    public CreateTaskServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public CreateTaskResponse createTaskResponse(CreateTaskRequest request) {
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        database.saveTask(task);
        return new CreateTaskResponse(true);
    }
}
