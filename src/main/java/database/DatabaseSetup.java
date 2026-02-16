package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createUserTable() {
        String sqlCreateTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "email Varchar(255) NOT NULL UNIQUE," +
                "password VARCHAR(255) NOT NULL" +
                ");";
        String sqlEmployee = "CREATE TABLE IF NOT EXISTS employees (" +
                "user_id INT PRIMARY KEY," +
                "rol VARCHAR(100) NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                ");";
        String sqlClient = "CREATE TABLE IF NOT EXISTS clients (" +
                "user_id INT PRIMARY KEY," +
                "type VARCHAR(100)," +
                "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                ");";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTableQuery);
            System.out.println("Tabla 'users' verificada/creada con éxito.");
            statement.execute(sqlEmployee);
            System.out.println("Tabla employees verificada/creada con éxito");
            statement.execute(sqlClient);
            System.out.println("Tabla clients verificada/creada con éxito");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void createVehicleTable() {

    }
}
