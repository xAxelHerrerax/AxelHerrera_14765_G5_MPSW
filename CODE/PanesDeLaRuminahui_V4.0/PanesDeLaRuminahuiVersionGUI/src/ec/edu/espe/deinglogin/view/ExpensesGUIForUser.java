package ec.edu.espe.deinglogin.view;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.deinglogin.controller.Printer;
import ec.edu.espe.deinglogin.utils.MongoDataConnect;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * 
 */
public class ExpensesGUIForUser extends javax.swing.JFrame {

    /**
     * Creates new form Expensive
     */
    public ExpensesGUIForUser() {
        initComponents();
        loadExpensesGUI();
    }

    public JButton getjButtoninforme() {
        return jButtoninforme;
    }

    public void setjButtoninforme(JButton jButtoninforme) {
        this.jButtoninforme = jButtoninforme;
    }
    public void loadRawMaterialData() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio");

        MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();

        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            String id = document.getString("Id");
            String nombre = document.getString("Name");
            int cantidad = document.getInteger("Ammount");
            float precio = document.getDouble("Price").floatValue();

            model.addRow(new Object[]{id, nombre, cantidad, precio});
        }

        tbExpensive.setModel(model);

        tbExpensive.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tbExpensive.getSelectedRow();
                    if (selectedRow != -1) {

                        btnDelete.setEnabled(true);
                    } else {

                        btnDelete.setEnabled(false);
                    }
                }
            }
        });
    }
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

    public void loadExpensesGUI() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");

        MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
        MongoCollection<Document> collection = mongoDataConnect.getCollection();

        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            String id = document.getString("Id");
            String nombre = document.getString("Name");
            int cantidad = document.getInteger("Ammount");
            float precio = document.getDouble("Price").floatValue();

            model.addRow(new Object[]{id, nombre, cantidad, precio});

            tbExpensive.setModel(model);

            tbExpensive.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        int selectedRow = tbExpensive.getSelectedRow();
                        if (selectedRow != -1) {

                            tbExpensive.setEnabled(true);
                        } else {

                            tbExpensive.setEnabled(false);
                        }
                    }
                }
            });
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbExpensive = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnPrit = new javax.swing.JButton();
        jButtoninforme = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbExpensive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tbExpensive);

        jScrollPane2.setViewportView(jScrollPane1);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPrit.setText("Ventas");
        btnPrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPritActionPerformed(evt);
            }
        });

        jButtoninforme.setText("informe");
        jButtoninforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoninformeActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton3.setText("Analisis");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButtoninforme)
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGap(39, 39, 39)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnPrit)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnPrit)
                    .addComponent(jButtoninforme)
                    .addComponent(jButton2)
                    .addComponent(btnDelete)
                    .addComponent(jButton3))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String userType = showUserTypeDialog();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void printTable(JTable table) {

        Printer printer = Printer.getInstance();
        printer.printTable(table);
    }
    private void btnPritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPritActionPerformed
        // Conectar a la base de datos y recuperar las ventas
    // Conectar a la base de datos y recuperar las ventas
    MongoDataConnect mongoDataConnect = new MongoDataConnect("income"); // Suponiendo que "income" es el nombre de la colección de ventas
    MongoCollection<Document> collection = mongoDataConnect.getCollection();
    FindIterable<Document> iterable = collection.find();

    // Construir la tabla con los datos de las ventas
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Cantidad");
    model.addColumn("Precio");
    model.addColumn("Precio Final");
    model.addColumn("Fecha de Compra"); // Agregar la columna para la fecha de compra

    // Iterar sobre las ventas
    for (Document doc : iterable) {
        String id = doc.getString("Id");
        String nombre = doc.getString("Name");
        int cantidad = doc.getInteger("Ammount");
        float precio = doc.getDouble("Price").floatValue();
        float precioFinal = doc.getDouble("Final Price").floatValue();
        String fechaCompra = doc.getString("FechaCompra"); // Obtener la fecha de compra del documento
        // Agregar la venta a la tabla
        model.addRow(new Object[]{id, nombre, cantidad, precio, precioFinal, fechaCompra});
    }
    // Crear la tabla con el modelo de datos
    JTable table = new JTable(model);
    // Presentar la tabla en un JOptionPane
    JOptionPane.showMessageDialog(null, new JScrollPane(table), "Ventas Realizadas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnPritActionPerformed

    private void jButtoninformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoninformeActionPerformed
      // Conectar a la base de datos y recuperar los productos
    MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial"); // Suponiendo que "productos" es el nombre de la colección
    MongoCollection<Document> collection = mongoDataConnect.getCollection();
    FindIterable<Document> iterable = collection.find();

    // Construir la tabla con los datos de los productos
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Cantidad");
    model.addColumn("Precio");

    // Iterar sobre los productos
    for (Document doc : iterable) {
        String id = doc.getString("Id");
        String nombre = doc.getString("Name");
        int cantidad = doc.getInteger("Ammount");
        float precio = doc.getDouble("Price").floatValue();

        // Agregar el producto a la tabla
        model.addRow(new Object[]{id, nombre, cantidad, precio});
    }

    // Crear la tabla con el modelo de datos
    JTable table = new JTable(model);

    // Definir el renderizador de celdas para aplicar los colores
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = (int) table.getValueAt(row, 2); // Obtener el valor de la cantidad en la tercera columna

            // Resaltar en rojo los productos con cantidad cero
            if (cantidad == 0) {
                c.setBackground(Color.RED);
            } else if (cantidad < 20) {
                // Resaltar en amarillo los productos con menos de 20
                c.setBackground(Color.YELLOW);
            } else {
                // Restablecer el color de fondo predeterminado para otros productos
                c.setBackground(table.getBackground());
            }

            return c;
        }
    });

    // Presentar la tabla en un JOptionPane
    JOptionPane.showMessageDialog(null, new JScrollPane(table), "Informe de Productos", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtoninformeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                // Obtener el índice de la fila seleccionada en la tabla
    int selectedRow = tbExpensive.getSelectedRow();
    
    // Verificar si se seleccionó una fila válida
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Obtener el ID del objeto en la fila seleccionada
    String id = (String) tbExpensive.getValueAt(selectedRow, 0); // Suponiendo que el ID está en la primera columna
    
    // Obtener la cantidad actual
    int cantidadActual = (int) tbExpensive.getValueAt(selectedRow, 2); // Suponiendo que la cantidad está en la tercera columna
    
    // Permitir al usuario editar la cantidad
    String nuevaCantidadStr = JOptionPane.showInputDialog(this, "Editar Cantidad:", cantidadActual);
    
    // Verificar si el usuario canceló la edición o no ingresó un nuevo valor
    if (nuevaCantidadStr == null || nuevaCantidadStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Se canceló la edición o la cantidad está vacía.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    // Convertir la nueva cantidad a entero
    int nuevaCantidad;
    try {
        nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Cantidad no válida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Actualizar los datos en la base de datos
    MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
    MongoCollection<Document> collection = mongoDataConnect.getCollection();
    
    // Crear un documento con los nuevos valores
    Document filter = new Document("Id", id);
    Document update = new Document("$set", new Document("Ammount", nuevaCantidad));
    
    // Actualizar el documento en la colección
    collection.updateOne(filter, update);
    
    // Actualizar la tabla con los nuevos datos
    loadRawMaterialData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbExpensive.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este dato?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                String id = (String) tbExpensive.getValueAt(selectedRow, 0);

                MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
                MongoCollection<Document> collection = mongoDataConnect.getCollection();

                collection.deleteOne(Filters.eq("Id", id));

                loadRawMaterialData();

                JOptionPane.showMessageDialog(this, " Dato eliminado correctamente ");

            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MongoDataConnect mongoDataConnect = new MongoDataConnect("income"); // Suponiendo que "income" es la colección de ventas
    MongoCollection<Document> collection = mongoDataConnect.getCollection();
    FindIterable<Document> iterable = collection.find();

    // Mapa para almacenar la cantidad vendida y el monto total de ventas para cada producto
    Map<String, Integer> cantidadPorProducto = new HashMap<>();
    Map<String, Float> montoPorProducto = new HashMap<>();

    // Iterar sobre las ventas para calcular la cantidad vendida y el monto total de ventas para cada producto
    for (Document doc : iterable) {
        String nombreProducto = doc.getString("Name");
        int cantidadVenta = doc.getInteger("Ammount");
        float montoVenta = doc.getDouble("Final Price").floatValue();

        // Actualizar la cantidad vendida y el monto total de ventas para el producto
        cantidadPorProducto.put(nombreProducto, cantidadPorProducto.getOrDefault(nombreProducto, 0) + cantidadVenta);
        montoPorProducto.put(nombreProducto, montoPorProducto.getOrDefault(nombreProducto, 0f) + montoVenta);
    }

    // Construir la tabla con los productos vendidos y la cantidad total de ventas realizadas de cada producto
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Producto");
    model.addColumn("Cantidad Vendida");
    model.addColumn("Monto Total Ventas");

    // Calcular los productos más vendidos y los menos vendidos
    String productoMasVendido = "";
    int cantidadMasVendida = 0;
    String productoMenosVendido = "";
    int cantidadMenosVendida = Integer.MAX_VALUE;

    for (Map.Entry<String, Integer> entry : cantidadPorProducto.entrySet()) {
        String producto = entry.getKey();
        int cantidadVendida = entry.getValue();
        float montoVentas = montoPorProducto.get(producto);

        // Agregar la fila a la tabla
        model.addRow(new Object[]{producto, cantidadVendida, montoVentas});

        // Actualizar el producto más vendido y el menos vendido
        if (cantidadVendida > cantidadMasVendida) {
            productoMasVendido = producto;
            cantidadMasVendida = cantidadVendida;
        }
        if (cantidadVendida < cantidadMenosVendida) {
            productoMenosVendido = producto;
            cantidadMenosVendida = cantidadVendida;
        }
    }

    // Mostrar la tabla de productos vendidos
    JTable table = new JTable(model);
    JOptionPane.showMessageDialog(null, new JScrollPane(table), "Productos Vendidos", JOptionPane.INFORMATION_MESSAGE);

    // Mostrar en un JLabel los productos más vendidos y los menos vendidos
    String mensaje = "Productos más vendidos: " + productoMasVendido + " (Cantidad: " + cantidadMasVendida + ")\n";
    mensaje += "Productos menos vendidos: " + productoMenosVendido + " (Cantidad: " + cantidadMenosVendida + ")";
    jLabel1.setText(mensaje);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ExpensesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpensesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpensesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpensesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpensesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtoninforme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbExpensive;
    // End of variables declaration//GEN-END:variables

}
