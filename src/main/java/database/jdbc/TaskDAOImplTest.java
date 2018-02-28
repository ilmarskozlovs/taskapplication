package database.jdbc;

import database.DatabaseUtil;
import database.TaskDAO;
import domain.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static domain.TaskBuilder.createTask;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TaskDAOImplTest {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private TaskDAO taskDAO = new TaskDAOImpl();

    @Before
    public void init(){
        databaseUtil.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception{
        Task task = create("AAA","BBB");
        assertThat(task.getId(),is(notNullValue()));

        Optional<Task> taskFromDB = taskDAO.getById(task.getId());

        assertThat(taskFromDB.isPresent(),is(true));
        assertEquals(task.getId(),taskFromDB.get().getId());
        assertEquals(task.getName(),taskFromDB.get().getName());
        assertEquals(task.getDescription(),taskFromDB.get().getDescription());

    }

    @Test
    public void testByName() throws Exception{
        Task task = create("AAA","BBB");

        Optional<Task> taskFromDB = taskDAO.getByName(task.getName());

        assertThat(taskFromDB.isPresent(),is(true));
        assertEquals(task.getId(),taskFromDB.get().getId());
        assertEquals(task.getName(),taskFromDB.get().getName());
        assertEquals(task.getDescription(),taskFromDB.get().getDescription());
    }

    @Test
    public void testGetAll() throws Exception{
        Task task1 = create("AAA","BBB");
        Task task2 = create("AAA","BBB");

        List<Task> tasks = taskDAO.getAll();

        assertThat(tasks.size(),is(2));
        assertThat(tasks.contains(task1),is(true));
        assertThat(tasks.contains(task2),is(true));
    }

    @Test
    public void testDelete() throws Exception{
        Task task = create("AAA","BBB");
        List<Task> tasks = taskDAO.getAll();
        assertThat(tasks.size(),is(1));

        taskDAO.delete(task);
        tasks = taskDAO.getAll();
        assertThat(tasks.size(),is(0));

        Optional<Task> taskFromDb = taskDAO.getById(task.getId());
        assertThat(taskFromDb.isPresent(),is(false));
    }

    private Task create(String name, String description){
        Task task = createTask()
                .withName(name)
                .withDescription(description).build();
        return taskDAO.save(task);
    }
}
