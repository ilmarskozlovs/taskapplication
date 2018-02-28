package businesslogic.impl;

import database.TaskDAO;
import businesslogic.RemoveAllTasksService;
import businesslogic.api.RemoveAllTasksRequest;
import businesslogic.api.RemoveAllTasksResponse;

public class RemoveAllTasksServiceImpl implements RemoveAllTasksService {

    private TaskDAO taskDAO;

    public RemoveAllTasksServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public RemoveAllTasksResponse removeAllTasks(RemoveAllTasksRequest request) {
//        boolean removed = taskDAO.delete(request.getTasks());
//        return new RemoveAllTasksResponse(removed);
        return null;
    }
}
