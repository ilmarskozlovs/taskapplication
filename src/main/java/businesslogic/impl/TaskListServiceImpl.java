package businesslogic.impl;

import database.Database;
import businesslogic.TaskListService;
import businesslogic.api.TaskListResponse;

public class TaskListServiceImpl implements TaskListService {

    private Database database;

    public TaskListServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public TaskListResponse getTasks() {
        return new TaskListResponse(database.getAllTasks());
    }
}
