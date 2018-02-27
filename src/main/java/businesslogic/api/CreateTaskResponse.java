package businesslogic.api;

public class CreateTaskResponse {

    private boolean result;

    public CreateTaskResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
}
