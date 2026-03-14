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
                "balance FLOAT(18,2) NOT NULL DEFAULT 0.0," +
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

    public static void createDockingStationsTable() {
        String sqlDockingStations = "CREATE TABLE IF NOT EXISTS docking_stations (" +
                "id int AUTO_INCREMENT PRIMARY KEY," +
                "latitude DOUBLE NOT NULL," +
                "longitud DOUBLE NOT NULL," +
                "capacity INT NOT NULL" +
                ");";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sqlDockingStations);
            System.out.println("Estructura de tablas para docking station creada");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void createVehicleTable() {
        String sqlVehicles = "CREATE TABLE IF NOT EXISTS vehicles (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "battery_percent DOUBLE DEFAULT 100.0,"+
                "active_faults INT DEFAULT 0," +
                "resolved_faults INT DEFAULT 0," +
                "rental_cost DOUBLE NOT NULL," +
                "consumption DOUBLE NOT NULL," +
                "vehicle_type ENUM('MOTO', 'BICYCLE', 'SCOOTER') NOT NULL" +
                ");";
        String sqlMotorbikes = "CREATE TABLE IF NOT EXISTS motorbikes (" +
                "vehicle_id INT PRIMARY KEY," +
                "current_lat DOUBLE," +
                "current_lng DOUBLE," +
                "FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE" +
                ");";
        String sqlStationaryVehicles = "CREATE TABLE IF NOT EXISTS stationary_vehicles (" +
                "vehicle_id INT PRIMARY KEY," +
                "base_id int," +
                "FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE," +
                "FOREIGN KEY (base_id) REFERENCES docking_stations(id) ON DELETE SET NULL" +
                ");";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sqlVehicles);
            statement.execute(sqlMotorbikes);
            statement.execute(sqlStationaryVehicles);
            System.out.println("Estructura de tablas de vehículos creada con éxisto");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
