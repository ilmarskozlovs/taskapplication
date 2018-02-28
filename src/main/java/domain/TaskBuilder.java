package domain;

public class TaskBuilder {

    private Long id;
    private String name;
    private String description;

    public TaskBuilder() {
    }

    public static TaskBuilder createTask(){
        return new TaskBuilder();
    }

    public static Task createTask(String name,String description){
        return createTask()
                .withName(name)
                .withDescription(description).build();
    }

    public Task build(){
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        return task;
    }

    public TaskBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public TaskBuilder withName(String name){
        this.name = name;
        return this;
    }

    public TaskBuilder withDescription(String description){
        this.description = description;
        return this;
    }
}
