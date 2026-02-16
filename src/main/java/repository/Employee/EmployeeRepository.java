package repository.Employee;

import database.DatabaseConnection;
import dto.Employee.EmployeePutDTO;
import model.User.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private final EmployeeRepositoryHelper employeeRepositoryHelper = new EmployeeRepositoryHelper();

    public void createEmployee(Employee employee) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            int userId = employeeRepositoryHelper.insertUser(connection, employee);
            employeeRepositoryHelper.insertEmployeeRole(connection, userId, employee.getRol());

            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Employee> getEmployeeList() {
        String sqlQuery = """
        SELECT u.id, u.name, u.email, e.rol
        FROM employees e
        JOIN users u ON e.user_id = u.id
    """;
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setRol(resultSet.getString("rol"));

                employeeList.add(employee);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        String sqlQuery = """
            SELECT u.id, u.name, u.email, e.rol
            FROM employees e
            JOIN users u ON e.user_id = u.id
            WHERE u.id = ?
        """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Employee employee = new Employee();

                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setRol(resultSet.getString("rol"));

                    return employee;
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void deleteEmployee(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            employeeRepositoryHelper.deleteUser(connection, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateUser(EmployeePutDTO employee, int id) {
        try (Connection connection = DatabaseConnection.getConnection();) {
            employeeRepositoryHelper.updateUser(connection, employee, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateRolEmployee(String rol, int id) {
        String sql = "UPDATE employees SET rol = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rol);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
