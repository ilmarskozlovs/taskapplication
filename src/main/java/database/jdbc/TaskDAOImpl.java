package database.jdbc;

import database.DBException;
import database.TaskDAO;
import domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static domain.TaskBuilder.createTask;

public class TaskDAOImpl extends DAOImpl implements TaskDAO {

    @Override
    public Task save(Task task) {
        Connection connection = null;
        try{
            connection = getConnection();
            String sql = "insert into TASKS(id, name, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                task.setId(rs.getLong(1));
            }
        }catch (Throwable e){
            System.out.println("Exception while execute TaskDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
        return task;
    }

    @Override
    public Optional<Task> getById(Long id) {
        Connection connection = null;
        try{
            connection = getConnection();
            String sql = "select * from TASKS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();
            Task task = null;
            if (rs.next()){
                task = createTask()
                .withId(rs.getLong("id"))
                .withName(rs.getString("name"))
                .withDescription(rs.getString("description"))
                .build();
            }
            return Optional.ofNullable(task);
        }catch (Throwable e){
            System.out.println("Exception while execute TaskDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Task> getByName(String name) {
        Connection connection = null;
        try{
            connection = getConnection();
            String sql = "select * from TASKS where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            ResultSet rs = preparedStatement.executeQuery();
            Task task = null;
            if (rs.next()){
                task = createTask()
                        .withId(rs.getLong("id"))
                        .withName(rs.getString("name"))
                        .withDescription(rs.getString("description"))
                        .build();
            }
            return Optional.ofNullable(task);
        }catch (Throwable e){
            System.out.println("Exception while execute TaskDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Task task) {

        Connection connection = null;
        try{
            connection = getConnection();
            String sql = "delete * from TASKS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,task.getId());
            preparedStatement.executeUpdate();

        }catch (Throwable e){
            System.out.println("Exception while execute TaskDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        Connection connection = null;
        try{
            connection = getConnection();
            String sql = "select * from TASKS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Task task = createTask()
                        .withId(rs.getLong("id"))
                        .withName(rs.getString("name"))
                        .withDescription(rs.getString("description")).build();
                        tasks.add(task);
            }
        }catch (Throwable e){
            System.out.println("Exception while execute TaskDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
        return tasks;
    }


}
