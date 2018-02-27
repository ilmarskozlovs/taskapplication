package businesslogic.impl;

import database.Database;
import businesslogic.RemoveTaskService;
import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;

public class RemoveTaskServiceImpl implements RemoveTaskService{

    private Database database;

    public RemoveTaskServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public RemoveTaskResponse removeByTitle(RemoveTaskRequest request) {
        boolean removed = database.removeTaskByTitle(request.getName());
        return new RemoveTaskResponse(removed);
    }
}
