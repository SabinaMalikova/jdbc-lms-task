package peaksoft.dao.daoImpl;
import peaksoft.config.Config;
import peaksoft.dao.EmployeeDao;
import peaksoft.model.Employee;
import peaksoft.model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection = Config.getConnection();

    @Override
    public void createEmployee() {
        String sql = """
                create table if not exists employees(
                id serial primary key,
                first_name varchar,
                last_name varchar,
                age int,
                email varchar,
                job_id int references jobs(id)
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("successfully created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = """
                insert into employees (first_name, last_name, age, email, job_id)
                values(?,?,?,?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setLong(5, employee.getJobId());
            preparedStatement.executeUpdate();
            System.out.println("successfully added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropTable() {
        String sql = """
                drop table if exists employees;
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("table successfully deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void cleanTable() {
        String sql = """
                truncate table employees;
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("table successfully cleaned");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        String sql = """
                update employees set first_name = ?, last_name = ?, age = ?, email = ?, job_id = ? where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setLong(5, employee.getJobId());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            System.out.println("successfully updated");
        } catch (SQLException e) {
            System.out.println("failed");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = """
                select * from employees
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getLong("job_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employee = new Employee();
        String sql = """
                select * from employees where email = ? 
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getLong("job_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        Map<Employee, Job> employeeJobMap = new HashMap<>();
        String sql = "select e.*, j.* from employees e inner join jobs j on e.job_id = j.id where e.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getLong("job_id"));

                Job job = new Job();
                job.setId(resultSet.getLong("job_id"));
                employeeJobMap.put(employee, job);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return employeeJobMap;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        List<Employee> employees = new ArrayList<>();
        String sql = """
                 select * from employees e inner join jobs j on e.job_id = j.id where j.position = ?    
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,position);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getLong("job_id"));
                employees.add(employee);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }
}
