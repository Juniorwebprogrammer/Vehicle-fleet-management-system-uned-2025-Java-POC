package repository.Client;

import dto.Client.ClientPutDTO;
import model.User.Client;

import java.sql.*;

public class ClientRespositoryHelper {

    int insertUser(Connection connection, Client client) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        )) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (!resultSet.next()) {
                throw new SQLException("No se pudo obtener el ID del cliente");
            }

            return resultSet.getInt(1);
        }
    }

    void insertClient(Connection connection, int userId, String type, double balance) throws SQLException {
        String sql = "INSERT INTO clients (user_id, type, balance) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, type);
            preparedStatement.setDouble(3, balance);
            preparedStatement.executeUpdate();
        }
    }

    void deleteClient(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    void updateUser(Connection connection, ClientPutDTO clientPutDTO, int id) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(3, id);

            preparedStatement.setString(1, clientPutDTO.getName());
            preparedStatement.setString(2, clientPutDTO.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Usuario no encontrado");
            } else {
                System.out.println("Usuario actualizado con éxito");
            }
        }
    }
}
