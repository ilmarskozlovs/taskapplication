package database.orm;

import database.TaskDAO;
import domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Task save(Task task) {
        session().save(task);
        return task;
    }

    @Override
    public Optional<Task> getById(Long id) {
        Task task = (Task) session().get(Task.class, id);
        return Optional.ofNullable(task);
    }

    @Override
    public Optional<Task> getByName(String name) {
        Task task = (Task) session().createCriteria(Task.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(task);
    }

    @Override
    public void delete(Task task) {
        session().delete(task);

    }

    @Override
    public List<Task> getAll() {
        return session()
                .createCriteria(Task.class)
                .list();
    }

    private Session session(){
        return sessionFactory.getCurrentSession();
    }
}
