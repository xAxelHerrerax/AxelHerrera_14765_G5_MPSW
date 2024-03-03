import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.deinglogin.utils.MongoDataConnect;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    // Otros métodos del administrador de productos aquí...

    // Método para obtener una lista de productos con cantidad igual a cero
    public List<Product> getProductsOutOfStock() {
        List<Product> productsOutOfStock = new ArrayList<>();

        // Reemplaza "inventory" con el nombre real de tu colección en la base de datos
        MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();

        FindIterable<Document> iterable = collection.find();

        for (Document document : iterable) {
            String productId = document.getString("Id");
            String productName = document.getString("Name");
            int amount = document.getInteger("Amount", 0); // Se asume que la cantidad es un entero

            // Verificar si la cantidad es igual a cero
            if (amount == 0) {
                Product product = new Product(productId, productName, amount);
                productsOutOfStock.add(product);
            }
        }

        return productsOutOfStock;
    }

    // Método para obtener una lista de productos con cantidad cero y presentarlos en una tabla
    public void presentProductsOutOfStockInTable(DefaultTableModel model) {
        List<Product> productsOutOfStock = getProductsOutOfStock();

        // Limpiar el modelo de la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los productos con cero cantidades a la tabla
        for (Product product : productsOutOfStock) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getAmount()});
        }
    }

    // Clase de ejemplo para representar un producto
    private static class Product {
        private String id;
        private String name;
        private int amount;

        public Product(String id, String name, int amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }

        // Métodos getter para acceder a los atributos
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
