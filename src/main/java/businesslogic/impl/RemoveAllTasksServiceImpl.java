package businesslogic.impl;

import database.Database;
import businesslogic.RemoveAllTasksService;
import businesslogic.api.RemoveAllTasksRequest;
import businesslogic.api.RemoveAllTasksResponse;

public class RemoveAllTasksServiceImpl implements RemoveAllTasksService {

    private Database database;

    public RemoveAllTasksServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public RemoveAllTasksResponse removeAllTasks(RemoveAllTasksRequest request) {
        boolean removed = database.removeAllTasks(request.getTasks());
        return new RemoveAllTasksResponse(removed);
    }
}
