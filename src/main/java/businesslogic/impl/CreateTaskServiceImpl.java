package businesslogic.impl;

import database.TaskDAO;
import businesslogic.CreateTaskService;
import businesslogic.api.CreateTaskRequest;
import businesslogic.api.CreateTaskResponse;
import domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
class CreateTaskServiceImpl implements CreateTaskService {

    @Autowired private TaskDAO taskDAO;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateTaskResponse createTaskResponse(CreateTaskRequest request) {
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        taskDAO.save(task);
        return new CreateTaskResponse(true);
    }
}
