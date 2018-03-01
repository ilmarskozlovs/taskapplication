package businesslogic.impl;

import database.TaskDAO;
import businesslogic.RemoveTaskService;
import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;
import domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class RemoveTaskServiceImpl implements RemoveTaskService{

    @Autowired
    private TaskDAO taskDAO;

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
