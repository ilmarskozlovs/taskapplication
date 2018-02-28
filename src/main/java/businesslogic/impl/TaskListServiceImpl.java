package businesslogic.impl;

import database.TaskDAO;
import businesslogic.TaskListService;
import businesslogic.api.TaskListResponse;

public class TaskListServiceImpl implements TaskListService {

    private TaskDAO taskDAO;

    public TaskListServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public TaskListResponse getTasks() {
        return new TaskListResponse(taskDAO.getAll());
    }
}
