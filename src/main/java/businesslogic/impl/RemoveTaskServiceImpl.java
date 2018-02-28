package businesslogic.impl;

import database.TaskDAO;
import businesslogic.RemoveTaskService;
import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;
import domain.Task;

import java.util.Optional;

public class RemoveTaskServiceImpl implements RemoveTaskService{

    private TaskDAO taskDAO;

    public RemoveTaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public RemoveTaskResponse removeByTitle(RemoveTaskRequest request) {
        Optional<Task> taskOptional = taskDAO.getByName(request.getName());
        if (taskOptional.isPresent()){
            Task task = taskOptional.get();
            taskDAO.delete(task);
            return new RemoveTaskResponse(true);
        }
        else return new RemoveTaskResponse(false);
    }
}
