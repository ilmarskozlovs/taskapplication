package businesslogic;

import businesslogic.api.RemoveTaskRequest;
import businesslogic.api.RemoveTaskResponse;

public interface RemoveTaskService {

    RemoveTaskResponse removeByTitle(RemoveTaskRequest request);

}
