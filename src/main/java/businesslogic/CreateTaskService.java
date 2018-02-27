package businesslogic;

import businesslogic.api.CreateTaskRequest;
import businesslogic.api.CreateTaskResponse;

public interface CreateTaskService {

    CreateTaskResponse createTaskResponse(CreateTaskRequest request);

}
