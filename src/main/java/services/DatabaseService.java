package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {

    private static final String DB_URL = "jdbc:sqlite:src/main/resources/smartcart.db";

    /**
     * Establishes a connection to the database.
     * @return A connection to the database.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Initializes the database by creating tables if they do not already exist.
     */
    public static void initializeDatabase() {
        String createProductsTable = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price REAL NOT NULL);";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createProductsTable);
            System.out.println("Database initialized.");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }
}
