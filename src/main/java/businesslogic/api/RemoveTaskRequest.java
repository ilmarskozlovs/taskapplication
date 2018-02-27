package businesslogic.api;

public class RemoveTaskRequest {

    private String name;

    public RemoveTaskRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
