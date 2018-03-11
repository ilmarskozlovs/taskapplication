package database;

import domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDAO {

    Task save(Task task);

    Optional<Task> getById(Long id);

    Optional<Task> getByName(String name);

    void delete(Task task);

    List getAll();

//    List<Task> removeAll();

}
