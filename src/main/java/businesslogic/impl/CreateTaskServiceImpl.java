package businesslogic.impl;

import database.TaskDAO;
import businesslogic.CreateTaskService;
import businesslogic.api.CreateTaskRequest;
import businesslogic.api.CreateTaskResponse;
import domain.Task;

public class CreateTaskServiceImpl implements CreateTaskService {

    private TaskDAO taskDAO;

    public CreateTaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public CreateTaskResponse createTaskResponse(CreateTaskRequest request) {
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        taskDAO.save(task);
        return new CreateTaskResponse(true);
    }
}
