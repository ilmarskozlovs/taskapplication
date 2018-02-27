package businesslogic.api;

public class RemoveAllTasksResponse {

    public boolean removed;

    public RemoveAllTasksResponse(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}
