package businesslogic.api;

public class CreateTaskRequest {

    private String name;
    private String description;

    public CreateTaskRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
