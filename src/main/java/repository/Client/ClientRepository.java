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

            int userId = clientRespositoryHelper.insertUser(connection, client);
            clientRespositoryHelper.insertClient(connection, userId, client.getType(), client.getBalance());

            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Client> getclientList() {
        String sqlQuery = """
            SELECT user.id, user.name, user.email, client.type, client.balance
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
                     client.setBalance(resultSet.getDouble("balance"));

                     clientList.add(client);
                 }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return clientList;
    }

    public Client getClientById(int id) {
        String sqlQuery = """
            SELECT user.id, user.name, client.type, client.balance, client.rentCount, client.vip
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
                    client.setBalance(resultSet.getDouble("balance"));
                    client.setRentCount(resultSet.getInt("rentCount"));
                    client.setVip(resultSet.getBoolean("vip"));

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

    public void updateBalanceClient(double balance, int id) {
        String sql = "UPDATE clients SET balance = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateRentCount(int rent, int id) {
        try (Connection connection = DatabaseConnection.getConnection()){
            clientRespositoryHelper.updateRentCount(connection, rent, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateVip(boolean vip, int id) {
        try (Connection connection = DatabaseConnection.getConnection()){
            clientRespositoryHelper.updateVipUser(connection, vip, id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
