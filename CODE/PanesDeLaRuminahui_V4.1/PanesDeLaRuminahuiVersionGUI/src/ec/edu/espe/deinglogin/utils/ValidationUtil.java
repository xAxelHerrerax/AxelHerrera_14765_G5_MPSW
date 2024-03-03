package ec.edu.espe.deinglogin.utils;

import java.util.regex.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidationUtil {

    public boolean validateIdNotExist(String input) {
        boolean idNotExist = false;
        try (Connection conn = SQLiteDataConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM rawMaterial WHERE Id = ?")) {

            pstmt.setString(1, input);
            try (ResultSet rs = pstmt.executeQuery()) {
                idNotExist = !rs.next(); // Si no hay resultados, el ID no existe
            }
        } catch (SQLException e) {
            System.err.println("Error validating ID: " + e.getMessage());
        }
        return idNotExist;
    }

    public boolean validateBarcode(String input) {
        // Expresión regular para verificar que el código de barras tenga exactamente 12 dígitos numéricos
        String regex = "\\d{12}";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex);

        // Verificar si el código de barras coincide con el patrón
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public boolean validateInt(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getInt(String input) {
        return Integer.parseInt(input);
    }

    public boolean validateFloat(String input) {
        try {
            float value = Float.parseFloat(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public float getFloat(String input) {
        return Float.parseFloat(input);
    }

    public boolean ValidateNumberString(String input) {
        return input.matches("^[0-9]+$");
    }

    public boolean ValidateLetterStringWithSpaces(String input) {
        return input.matches("^[ a-zA-Z ]+$");
    }
}
