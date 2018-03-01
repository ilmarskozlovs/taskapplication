package businesslogic.impl;

import database.TaskDAO;
import businesslogic.RemoveAllTasksService;
import businesslogic.api.RemoveAllTasksRequest;
import businesslogic.api.RemoveAllTasksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RemoveAllTasksServiceImpl implements RemoveAllTasksService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public RemoveAllTasksResponse removeAllTasks(RemoveAllTasksRequest request) {
//        boolean removed = taskDAO.delete(request.getTasks());
//        return new RemoveAllTasksResponse(removed);
        return null;
    }
}
