package repository.Client;

import database.DatabaseConnection;
import dto.Client.ClientPutDTO;
import model.User.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private final ClientRespositoryHelper clientRespositoryHelper = new ClientRespositoryHelper();

    public void createClient(Client client) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            int userId = clientRespositoryHelper.insertClient(connection, client);
            clientRespositoryHelper.insertClientType(connection, userId, client.getType());

            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Client> getclientList() {
        String sqlQuery = """
            SELECT user.id, user.name, user.email, client.type
            FROM clients client
            JOIN users user ON client.user_id = user.id
        """;

        List<Client> clientList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement((sqlQuery));
             ResultSet resultSet = preparedStatement.executeQuery()) {

                 while (resultSet.next()) {
                     Client client = new Client();

                     client.setId(resultSet.getInt("id"));
                     client.setName(resultSet.getString("name"));
                     client.setEmail(resultSet.getString("email"));
                     client.setType(resultSet.getString("type"));

                     clientList.add(client);
                 }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return clientList;
    }

    public Client getClientById(int id) {
        String sqlQuery = """
            SELECT user.id, user.name, client.type
            FROM clients client
            JOIN users user ON client.user_id = user.id
            WHERE user.id = ?    
        """;

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Client client = new Client();

                    client.setId(resultSet.getInt("id"));
                    client.setName(resultSet.getString("name"));
                    client.setType(resultSet.getString("type"));

                    return  client;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void deleteClientId(int id) {
        try (Connection connection = DatabaseConnection.getConnection()){
            clientRespositoryHelper.deleteClient(connection, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateClient(ClientPutDTO clientPutDTO, int id) {
        try (Connection connection = DatabaseConnection.getConnection()){
            clientRespositoryHelper.updateUser(connection, clientPutDTO, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateTypeClient(String type, int id) {
        String sql = "UPDATE clients SET type = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
