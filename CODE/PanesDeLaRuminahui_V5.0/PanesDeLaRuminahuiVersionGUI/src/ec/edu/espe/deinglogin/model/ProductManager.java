import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductManager {

    private static final String DB_URL = "jdbc:sqlite:D:/DIEGO/Documents/SOFTWARE/MOD DESARROLLO SOFTWARE/u2/proyecto/PanesDeLaRuminahuiVersionGUI3/PanesDeLaRuminahuiVersionGUI/database/database.db";

    public List<Product> getProductsOutOfStock() {
        List<Product> productsOutOfStock = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE Amount = 0";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String productId = rs.getString("Id");
                String productName = rs.getString("Name");
                int amount = rs.getInt("Amount");

                Product product = new Product(productId, productName, amount);
                productsOutOfStock.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error getting products out of stock: " + e.getMessage());
        }

        return productsOutOfStock;
    }

    public void presentProductsOutOfStockInTable(DefaultTableModel model) {
        List<Product> productsOutOfStock = getProductsOutOfStock();

        model.setRowCount(0);

        for (Product product : productsOutOfStock) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getAmount()});
        }
    }

    // Resto de métodos del administrador de productos
    // ...

    private static class Product {
        private String id;
        private String name;
        private int amount;

        public Product(String id, String name, int amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
