package businesslogic;

import businesslogic.api.RemoveAllTasksRequest;
import businesslogic.api.RemoveAllTasksResponse;

public interface RemoveAllTasksService {

    RemoveAllTasksResponse removeAllTasks(RemoveAllTasksRequest request);

}
