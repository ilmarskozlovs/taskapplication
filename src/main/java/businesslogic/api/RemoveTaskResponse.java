package businesslogic.api;

public class RemoveTaskResponse {

    private boolean removed;

    public RemoveTaskResponse(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}
