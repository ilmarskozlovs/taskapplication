package businesslogic.impl;

import database.TaskDAO;
import businesslogic.TaskListService;
import businesslogic.api.TaskListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TaskListServiceImpl implements TaskListService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public TaskListResponse getTasks() {
        return new TaskListResponse(taskDAO.getAll());
    }
}
