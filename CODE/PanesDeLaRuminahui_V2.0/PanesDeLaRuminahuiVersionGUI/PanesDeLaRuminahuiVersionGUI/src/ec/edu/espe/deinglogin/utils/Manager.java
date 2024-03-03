package ec.edu.espe.deinglogin.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import ec.edu.espe.deinglogin.model.Sale;
import ec.edu.espe.deinglogin.view.LoginGUI;
import ec.edu.espe.deinglogin.view.MainPage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.deinglogin.controller.Encrypted;
import java.util.List;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class Manager {

    public void inventoryConnect(ArrayList<Sale> saleList, DefaultTableModel model, javax.swing.JTable tabList) {

        Sale sale;

        MongoDataConnect mongoDataConnect = new MongoDataConnect("inventory");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();
        
        int sizeSaleList = saleList.size();

        List<Integer> rowsToRemove = new ArrayList<>();

        for (int i = 0; i < sizeSaleList; i++) {
            sale = saleList.get(i);
            Bson usernameFilter = Filters.eq("Id", sale.getId());
            Document productDocument = collection.find(usernameFilter).first();

            if (productDocument != null) {
                int amount = productDocument.getInteger("Ammount");
                amount = amount - sale.getAmount();
                Bson update = new Document("$set", new Document("Ammount", amount));
                collection.updateOne(usernameFilter, update);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

            rowsToRemove.add(i);
        }

        for (int i = rowsToRemove.size() - 1; i >= 0; i--) {
            int rowIndex = rowsToRemove.get(i);
            if (rowIndex >= 0 && rowIndex < model.getRowCount()) {
                model.removeRow(rowIndex);
            }
        }

        tabList.setModel(model);

    }

    public void incomeConnect(ArrayList<Sale> saleList, float finalPrice) {

        Sale sale;

        MongoDataConnect mongoDataConnect = new MongoDataConnect("income");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();

        int id;
        String name;
        int amount;
        float price;

        for (int i = 0; i < saleList.size(); i++) {

            sale = saleList.get(i);

            id = sale.getId();
            name = sale.getNameProduct();
            amount = sale.getAmount();
            price = sale.getTotalPrice();

            Document doc1 = new Document("Id", id).append("Name", name).append("Ammount", amount).append("Price", price).append("Final Price", finalPrice);

            collection.insertOne(doc1);
        }

    }

    public boolean loginConnect(String username, String password) {

        boolean txtDelete = true;

        MongoDataConnect mongoDataConnect = new MongoDataConnect("login");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();

        String cifrada = Encrypted.encryptPassword(password);

        Bson usernameFilter = Filters.eq("User", username);
        Document userDocument = collection.find(usernameFilter).first();

        if (userDocument != null) {
            String storedPassword = userDocument.getString("Pasword");
            if (storedPassword.equals(cifrada)) {

                Date fechaActual = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fechaTexto = sdf.format(fechaActual);

                userDocument.append("Fecha de entrada:  ", fechaTexto);

                collection.replaceOne(usernameFilter, userDocument);

                txtDelete = false;

            } else {
                JOptionPane.showMessageDialog(null, "Contraseña/Usuario incorrecta ");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña no encontrado ");

        }
        return txtDelete;
    }
}
