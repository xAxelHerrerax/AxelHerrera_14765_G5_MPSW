package ec.edu.espe.deinglogin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private static final String DB_URL = "jdbc:sqlite:database/database.db";

    public static void createDocument() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "INSERT INTO Login (username, password) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                Scanner readData = new Scanner(System.in);
                System.out.print("Username: ");
                String username = readData.next();
                System.out.print("Password: ");
                String password = readData.next();
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error creating document: " + e.getMessage());
        }
    }

    // Implementa los métodos deleteDocument(), readDocument(), modifyDocument() y showDatabase() de manera similar.
}
