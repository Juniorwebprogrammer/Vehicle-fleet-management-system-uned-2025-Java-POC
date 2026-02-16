package repository.Employee;

import dto.Employee.EmployeePutDTO;
import model.User.Employee;

import java.sql.*;

class EmployeeRepositoryHelper {

    int insertUser(Connection connection, Employee employee) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        )) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPassword());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("No se pudo obtener el ID del usuario");
            }
            return rs.getInt(1);
        }
    }

    void insertEmployeeRole(Connection connection, int userId, String rol) throws SQLException {
        String sql = "INSERT INTO employees (user_id, rol) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, rol);
            ps.executeUpdate();
        }
    }

    void deleteUser(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    void updateUser(Connection connection, EmployeePutDTO employee, int id) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate(); // ✅ no olvides ejecutar

            if (rowsAffected == 0) {
                System.out.println("Usuario no encontrado");
            } else {
                System.out.println("Usuario actualizado con éxito");
            }
        }
    }
}
