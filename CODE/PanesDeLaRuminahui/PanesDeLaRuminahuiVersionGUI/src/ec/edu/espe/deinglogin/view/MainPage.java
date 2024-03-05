package ec.edu.espe.deinglogin.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import ec.edu.espe.deinglogin.model.Product;
import ec.edu.espe.deinglogin.model.Sale;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.deinglogin.utils.Manager;
import ec.edu.espe.deinglogin.utils.SQLiteDataConnect;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;
import ec.edu.espe.deinglogin.utils.ValidationUtil;
import java.awt.HeadlessException;
//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ec.edu.espe.deinglogin.utils.SQLiteDataConnect;
import ec.edu.espe.deinglogin.model.Product;
import java.sql.Statement;


/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    DefaultTableModel model = new DefaultTableModel();
    Product product;
    ArrayList<Sale> saleList = new ArrayList<>();
    Sale sale;
    float iva = 0.12F;

    public MainPage() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        initAllPanel();
        addTable();
        loadRawMaterialData();
        loadInventoryGUI();
        txtId.setEditable(false);

    }

    public void loadRawMaterialData() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try {
            // Conectar a la base de datos SQLite
            Connection connection = SQLiteDataConnect.getConnection();

            // Crear la consulta SQL para obtener los datos necesarios
            String query = "SELECT Id, Name FROM inventory";

            // Ejecutar la consulta
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Iterar sobre los resultados y agregar los nombres al modelo del JComboBox
            while (resultSet.next()) {
                String id = resultSet.getString("Id");
                String nombre = resultSet.getString("Name");
                model.addElement(nombre);
            }

            // Establecer el modelo del JComboBox
            comboBoxRawMaterial.setModel(model);

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getCorrespondingId(String selectedName) {
    String correspondingId = "";

    try {
        // Conectar a la base de datos SQLite
        Connection connection = SQLiteDataConnect.getConnection();

        // Crear la consulta SQL para obtener el ID correspondiente al nombre seleccionado
        String query = "SELECT Id FROM rawMaterial WHERE Name = ?";

        // Preparar la consulta
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, selectedName);

        // Ejecutar la consulta
        ResultSet resultSet = preparedStatement.executeQuery();

        // Verificar si se encontró un resultado y obtener el ID correspondiente
        if (resultSet.next()) {
            correspondingId = resultSet.getString("Id");
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        preparedStatement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return correspondingId;
}

    public void loadInventoryGUI() {
    try {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Producto");
        model.addColumn("Cantidad");

        // Conectar a la base de datos SQLite
        Connection connection = SQLiteDataConnect.getConnection();

        // Crear la consulta SQL para obtener los datos del inventario
        String query = "SELECT Id, Name, Amount FROM rawMaterial";

        // Preparar la consulta
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Ejecutar la consulta
        ResultSet resultSet = preparedStatement.executeQuery();

        // Iterar sobre los resultados y agregarlos al modelo de la tabla
        while (resultSet.next()) {
            String id = resultSet.getString("Id");
            String nombre = resultSet.getString("Name");
            int cantidad = resultSet.getInt("Amount");

            model.addRow(new Object[]{id, nombre, cantidad});
        }

        // Asignar el modelo de la tabla
        tbInventory.setModel(model);

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        preparedStatement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        bntNewProduct = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JScrollPane();
        tbInventory = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        comboBoxRawMaterial = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnFinishSale = new javax.swing.JButton();
        btnNewSale = new javax.swing.JButton();
        txtFinalPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInventory = new javax.swing.JMenu();
        itmAddRawMaterial = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        itmFrmBread = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniHelp = new javax.swing.JMenuItem();
        mnExit = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panes de la Rumiñahui");
        setName("mainPage"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 625));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Código del Producto");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Cantidad");

        txtAmount.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });

        bntNewProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bntNewProduct.setText("Borrar");
        bntNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewProductActionPerformed(evt);
            }
        });

        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAddProduct.setText("Agregar Producto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        btnAddProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddProductKeyPressed(evt);
            }
        });

        tbInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Cantidad"
            }
        ));
        tbInventory.setEnabled(false);
        tblInventory.setViewportView(tbInventory);

        jScrollPane3.setViewportView(tblInventory);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("IVA");

        comboBoxRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRawMaterialActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBoxRawMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(bntNewProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddProduct)
                        .addGap(116, 116, 116))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 377, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxRawMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct)
                    .addComponent(bntNewProduct))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(665, 625));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Lista de Productos");

        btnFinishSale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnFinishSale.setText("Finalizar Venta");
        btnFinishSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishSaleActionPerformed(evt);
            }
        });

        btnNewSale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnNewSale.setText("Cancelar Venta");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });

        txtFinalPrice.setEditable(false);
        txtFinalPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtFinalPrice.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtFinalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalPriceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Precio Final");

        tabList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tabList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(btnNewSale)
                .addGap(125, 125, 125)
                .addComponent(btnFinishSale)
                .addGap(135, 135, 135))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(txtFinalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtFinalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewSale)
                    .addComponent(btnFinishSale))
                .addGap(81, 81, 81))
        );

        mnuInventory.setText("Inventario");
        mnuInventory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itmAddRawMaterial.setText("Inventario");
        itmAddRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddRawMaterialActionPerformed(evt);
            }
        });
        mnuInventory.add(itmAddRawMaterial);

        jMenuItem4.setText("Maquinaria");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuInventory.add(jMenuItem4);

        jMenuItem5.setText("Registro de productos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuInventory.add(jMenuItem5);

        itmFrmBread.setText("Hornear");
        itmFrmBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmFrmBreadActionPerformed(evt);
            }
        });
        mnuInventory.add(itmFrmBread);

        jMenuBar1.add(mnuInventory);

        jMenu1.setText("Presupuesto");

        jMenuItem2.setText("Ingresos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Gastos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        mnuHelp.setText("Ayuda");
        mnuHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniHelp.setText("Contacto");
        mniHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHelpActionPerformed(evt);
            }
        });
        mnuHelp.add(mniHelp);

        jMenuBar1.add(mnuHelp);

        mnExit.setText("Finalizar");

        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnExit.add(jMenuItem1);

        jMenuBar1.add(mnExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewProductActionPerformed
        initPanelProduct();
    }//GEN-LAST:event_bntNewProductActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

    }//GEN-LAST:event_txtIdKeyReleased

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed

        ValidationUtil validationUtil = new ValidationUtil();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (validationUtil.validateInt(txtId.getText())) {

                String id = txtId.getText();
                validateProduct(id);

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
            }

        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void validateProduct(String id) {
    try {
        // Conectar a la base de datos SQLite
        Connection connection = SQLiteDataConnect.getConnection();

        // Crear la consulta SQL para obtener los detalles del producto con el ID dado
        String query = "SELECT * FROM rawMaterial WHERE Id = ?";

        // Preparar la consulta
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);

        // Ejecutar la consulta
        ResultSet resultSet = preparedStatement.executeQuery();

        // Verificar si se encontró el producto y obtener sus detalles
        if (resultSet.next()) {
            String nameProduct = resultSet.getString("Name");
            float budgetProduct = resultSet.getFloat("Price");
            int stock = resultSet.getInt("Amount");
            product = new Product(id, nameProduct, budgetProduct, stock);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado ");
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        preparedStatement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        addProductAction();
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void addProductAction() throws NumberFormatException, HeadlessException {

        ValidationUtil validationUtil = new ValidationUtil();

        boolean validate = true;
        int amount = 0;
        float totalPrice = 0;
        float priceIVA = 0;

        if (validationUtil.validateBarcode(txtId.getText())) {
            btnAddProduct.requestFocus();
            String id = txtId.getText();
            validateProduct(id);
            txtAmount.requestFocus();

            if (validationUtil.validateInt(txtAmount.getText())) {

                amount = Integer.parseInt(txtAmount.getText());

                // Validar que la cantidad no supere la existente
                if (amount > product.getStock()) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada supera la cantidad existente del producto.");
                    validate = false;
                } else {
                    // txtFullValue.setText(String.valueOf(product.getBudgetProduct() * amount));
                    totalPrice = product.getBudgetProduct() * amount;
                    priceIVA = totalPrice * iva + totalPrice;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número positivo para la Cantidad");
                validate = false;
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número positivo para el Id");
            txtId.setText("");
            txtId.requestFocus();
            validate = false;
        }

        if (validate) {
            sale = new Sale(product.getId(), product.getNameProduct(), amount, product.getBudgetProduct(), totalPrice);
            saleList.add(sale);
            addProductToList();
            initPanelProduct();
        }
    }

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        DefaultTableModel newModel = new DefaultTableModel();
        newModel.addColumn("Id");
        newModel.addColumn("Producto");
        newModel.addColumn("Cantidad");

        tabList.setModel(newModel);
        initAllPanel();
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnFinishSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishSaleActionPerformed

        saveSale();
        finishSale();
        initAllPanel();
        loadInventoryGUI();
    }//GEN-LAST:event_btnFinishSaleActionPerformed

    private void finishSale() throws HeadlessException {

        Manager mongoConnect = new Manager();
        mongoConnect.inventoryConnect(saleList, model, tabList);

    }

    private void saveSale() {

        float finalPrice = Float.parseFloat(txtFinalPrice.getText());

        Manager mongoConnect = new Manager();
        mongoConnect.incomeConnect(saleList, finalPrice);
    }

    private void btnAddProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddProductKeyPressed
        addProductAction();
    }//GEN-LAST:event_btnAddProductKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private String showUserTypeDialog() {
        String[] options = {"Administrador", "Control de existencias"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Seleccione el tipo de usuario:",
                "Tipo de Usuario",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == JOptionPane.CLOSED_OPTION) {
            return null;
        } else {
            String selectedOption = options[choice];
            if (selectedOption.equals("Control de existencias")) {
                ExpensesGUIForUser expensesGUIForUser = new ExpensesGUIForUser();
                expensesGUIForUser.setVisible(true);
                this.setVisible(false);
            }
            if (selectedOption.equals("Administrador")) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                this.setVisible(false);
            }
            return selectedOption;
        }
    }
    
    private void itmAddRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddRawMaterialActionPerformed
        InventoryGUI inventoryGUI = new InventoryGUI();
        inventoryGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itmAddRawMaterialActionPerformed

    private void txtFinalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalPriceActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IncomeGUI incomeGUI = new IncomeGUI();
        incomeGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Por faovr contactese con el tecnico");
    }//GEN-LAST:event_mniHelpActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ExpensesGUI expensesGUI = new ExpensesGUI();
        expensesGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        MachineryGUI machineryGUI = new MachineryGUI();
        machineryGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        RawMaterialGUI rawMaterialGUI = new RawMaterialGUI();
                System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        rawMaterialGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void itmFrmBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmFrmBreadActionPerformed
        FrmBread frmBread = new FrmBread();
        frmBread.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itmFrmBreadActionPerformed

    private void comboBoxRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRawMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRawMaterialActionPerformed

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        ValidationUtil validationUtil = new ValidationUtil();

        int amount = 0;
        float totalPrice = 0;
        float priceIVA = 0;

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (validationUtil.validateBarcode(txtId.getText())) {
                btnAddProduct.requestFocus();
                String id = txtId.getText();
                validateProduct(id);
                txtAmount.requestFocus();
                //txtUnitValue.setText(String.valueOf(product.getBudgetProduct()));
                txtIVA.setText(String.valueOf(iva * 100));
                amount = Integer.parseInt(txtAmount.getText());
                totalPrice = product.getBudgetProduct() * amount;
                priceIVA = totalPrice * iva + totalPrice;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para el Id");
                txtId.setText("");
                txtId.requestFocus();
            }
            if (validationUtil.validateInt(txtAmount.getText())) {

                amount = Integer.parseInt(txtAmount.getText());
                //txtFullValue.setText(String.valueOf(product.getBudgetProduct() * amount));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un un numero positivo para la Cantidad");
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
            btnAddProduct.requestFocus();
        }
    }//GEN-LAST:event_txtAmountKeyPressed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void addProductToList() {
        float finalPrice = Float.parseFloat(txtFinalPrice.getText());
        model.addRow(new Object[]{sale.getId(), sale.getNameProduct(), sale.getAmount(), sale.getUnitPrice(), sale.getTotalPrice()});
        tabList.setModel(model);
        finalPrice = finalPrice + sale.getTotalPrice();
        txtFinalPrice.setText(String.valueOf(finalPrice));
    }

    private void initAllPanel() {
        initPanelProduct();
        txtFinalPrice.setText("0.0");
    }

    private void initPanelProduct() {
        txtId.setText("");
        txtAmount.setText("");
        //txtUnitValue.setText("0.0");
        //txtFullValue.setText("0.0");
        txtId.requestFocus();
    }

    private void addTable() {
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Precio Total");
        loadRawMaterialData();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNewProduct;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnFinishSale;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JComboBox<String> comboBoxRawMaterial;
    private javax.swing.JMenuItem itmAddRawMaterial;
    private javax.swing.JMenuItem itmFrmBread;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mnExit;
    private javax.swing.JMenuItem mniHelp;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuInventory;
    private javax.swing.JTable tabList;
    private javax.swing.JTable tbInventory;
    private javax.swing.JScrollPane tblInventory;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtFinalPrice;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
