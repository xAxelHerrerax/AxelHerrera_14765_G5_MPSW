package ec.edu.espe.deinglogin.utils;

import ec.edu.espe.deinglogin.model.Sale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Manager {

    private Connection connection;

    public Manager() {
        try {
            // Conexión a la base de datos SQLite (debe existir el archivo de la base de datos)
            connection = DriverManager.getConnection("jdbc:sqlite:database/database.db");
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos SQLite: " + e.getMessage());
        }
    }

    public void inventoryConnect(ArrayList<Sale> saleList, DefaultTableModel model, JTable tabList) {
        Sale sale;
        int sizeSaleList = saleList.size();
        ArrayList<Integer> rowsToRemove = new ArrayList<>();

        try {
            for (int i = 0; i < sizeSaleList; i++) {
                sale = saleList.get(i);
                String updateQuery = "UPDATE rawMaterial SET Amount = Amount - ? WHERE Id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, sale.getAmount());
                updateStatement.setString(2, sale.getId());
                updateStatement.executeUpdate();
                
                rowsToRemove.add(i);
            }

            for (int i = rowsToRemove.size() - 1; i >= 0; i--) {
                int rowIndex = rowsToRemove.get(i);
                if (rowIndex >= 0 && rowIndex < model.getRowCount()) {
                    model.removeRow(rowIndex);
                }
            }

            tabList.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void incomeConnect(ArrayList<Sale> saleList, float finalPrice) {
        
        try {
            String id;
            String name;
            int amount;
            float price;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaCompra = dateFormat.format(new Date());

            for (Sale sale : saleList) {
                id = sale.getId();
                name = sale.getNameProduct();
                amount = sale.getAmount();
                price = sale.getTotalPrice();
                String insertQuery = "INSERT INTO Income (Id, Name, Ammount, Price, FinalPrice, Date) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, id);
                insertStatement.setString(2, name);
                insertStatement.setInt(3, amount);
                insertStatement.setFloat(4, price);
                insertStatement.setFloat(5, finalPrice);
                insertStatement.setString(6, fechaCompra);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginConnect(String username, String password) {
        boolean txtDelete = true;

        try {
            String storedPassword = null;

            // Consulta para verificar las credenciales del usuario
            String selectQuery = "SELECT Password FROM Users WHERE Username = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, username);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                storedPassword = resultSet.getString("Password");
            }

            if (storedPassword != null && storedPassword.equals(password)) {
                Date fechaActual = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fechaTexto = sdf.format(fechaActual);

                // Actualizar la información en la base de datos
                String updateQuery = "UPDATE Users SET LastLogin = ? WHERE Username = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, fechaTexto);
                updateStatement.setString(2, username);
                updateStatement.executeUpdate();

                txtDelete = false;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña/Usuario incorrecta");
                txtDelete = true;
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return txtDelete;
    }
}
