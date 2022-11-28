
package gimnasio_GUI;

import ConMySql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class frmClientes extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Statement stm;
    java.sql.Connection conection;

   
    public frmClientes() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        CargarCliente();
        configTabla();
        
        jButton_del.setEnabled(false);
        jButton_save.setEnabled(false);
        jButton_mod.setEnabled(false);
        
        jTextField_Cedula.setEditable(false);
        jTextField_fdn.setEnabled(false);
        jTextField_name.setEditable(false);
        jTextField_Telefono.setEditable(false);
        jTextField_Altura.setEditable(false);
        jTextField_Peso.setEditable(false);
    }
    private void Clean(){
        jTextField_Cedula.setText(null);
        jTextField_name.setText(null);
        jTextField_Telefono.setText(null);
        jTextField_Altura.setText(null);
        jTextField_Peso.setText(null);
        jTextField_fdn.setDate(null);
        jTextField_name.requestFocus();
    }
     public static String convertTostring(Date Date){
            DateFormat df;
            String fech = null;
            df = new SimpleDateFormat("yyyy-MM-d");
            fech = df.format(Date);
            return fech;
        }
    
    private void Allow(){
        jTextField_Cedula.setEditable(true);
        jTextField_Peso.setEditable(true);
        jTextField_Telefono.setEditable(true);
        jTextField_name.setEditable(true);
        jTextField_Altura.setEditable(true);
        jTextField_fdn.setEnabled(true);
        jTextField_name.requestFocus();
    }
    
     
    private void configTabla(){
        jTable_Clientes.setAutoResizeMode(0);
        TableColumnModel columnModel = jTable_Clientes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(120);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(120);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        jTable_Clientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTable_Clientes.getColumnModel().getColumn(6).setCellRenderer(tcr);
    } 
    
    private void CargarCliente(){
        jTable_Clientes.setAutoResizeMode(0);
        try {
            conection = Connection.getConection();
            String[] titulos ={"ID Cliente","Nombre", "Cédula","Teléfono"," Fecha de Nacimiento","Peso", "Altura"};
            String sql="SELECT * FROM cliente";
            modelo= new DefaultTableModel(null, titulos);
            stm = conection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            
            String[] fila = new String[8];
            
            while(rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("nombre");
                fila[2]=rs.getString("cedula");
                fila[3]=rs.getString("telefono");
                fila[4]=rs.getString("fdn");
                fila[5]=rs.getString("peso");
                fila[6]=rs.getString("altura");
                modelo.addRow(fila);
            }
            jTable_Clientes.setModel(modelo);
            configTabla();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_name = new javax.swing.JTextField();
        jTextField_Cedula = new javax.swing.JTextField();
        jTextField_Telefono = new javax.swing.JTextField();
        jTextField_Peso = new javax.swing.JTextField();
        jTextField_Altura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_addCliente = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_mod = new javax.swing.JButton();
        jButton_del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField_fdn = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Cédula:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Peso:");

        jLabel6.setText("Altura:");

        jButton_addCliente.setText("Agregar");
        jButton_addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addClienteActionPerformed(evt);
            }
        });

        jButton_save.setText("Guardar");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_mod.setText("Modificar");
        jButton_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modActionPerformed(evt);
            }
        });

        jButton_del.setText("Eliminar");
        jButton_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_delActionPerformed(evt);
            }
        });

        jTable_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Clientes);

        jLabel7.setText("CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton_del)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_addCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_mod)
                        .addGap(0, 0, 0)
                        .addComponent(jButton_save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Peso)
                            .addComponent(jTextField_Telefono)
                            .addComponent(jTextField_Cedula)
                            .addComponent(jTextField_name)
                            .addComponent(jTextField_Altura, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jTextField_fdn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_addCliente)
                                    .addComponent(jButton_save)
                                    .addComponent(jButton_mod)
                                    .addComponent(jButton_del)))
                            .addComponent(jTextField_fdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        jButton_save.setEnabled(true);
        Allow();
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        try {
            String sql = "INSERT INTO `cliente` (`id`,`nombre`, `cedula`, `telefono`, `fdn`, `peso`,`altura`) VALUES (null,?,?,?,?,?,?)";
            PreparedStatement ps =conection.prepareCall(sql);
            
            ps.setString(1, jTextField_name.getText());
            ps.setString(2, jTextField_Cedula.getText());
            ps.setString(3, jTextField_Telefono.getText());
            ps.setString(4, convertTostring(jTextField_fdn.getDate()));
            ps.setString(5, jTextField_Peso.getText());
            ps.setString(6, jTextField_Altura.getText());
            
            
            int n=ps.executeUpdate();
                        
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar, verifique "+e.getMessage());
        }
        CargarCliente();
        Clean();
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_delActionPerformed
       try {
           int fila=0;
           String sql;
           if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar el registro?",
                "Eliminación Registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                fila =jTable_Clientes.getSelectedRow();
                sql = "DELETE FROM cliente WHERE id="+jTable_Clientes.getValueAt(fila, 0);
                stm=conection.createStatement();
                int n = stm.executeUpdate(sql);
                if(n>0){
                    CargarCliente();
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                }
           }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR, VERIFIQUE:  "+e.getMessage());
        }
    }//GEN-LAST:event_jButton_delActionPerformed

    private void jButton_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modActionPerformed
        try {
           int fila;
           String sql;
           
           if (JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar los datos del registro?",
                "Registro actualizado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    fila =jTable_Clientes.getSelectedRow();
                    String fecha = convertTostring(jTextField_fdn.getDate());
                    sql="UPDATE `profesor` SET `id`='"+jTable_Clientes.getValueAt(fila, 0)+"',`nombre`='"+jTextField_name.getText()+"',`cedula`='"+jTextField_Cedula.getText()+
                        "',`telefono`='"+jTextField_Telefono.getText()+
                        "',`fdn`='"+fecha+"',`peso`='"+jTextField_Peso.getText()+
                        "',`altura`='"+jTextField_Altura.getText()+
                        "'WHERE "+jTable_Clientes.getValueAt(fila, 0)+"";
                    PreparedStatement ps = conection.prepareCall(sql);
                    int n= ps.executeUpdate();
                if(n>0){
                    CargarCliente();
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
            }    
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
        }
    }//GEN-LAST:event_jButton_modActionPerformed

    private void jTable_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientesMouseClicked
        Allow();
        
        jButton_del.setEnabled(true);
        jButton_mod.setEnabled(true);
        jButton_save.setEnabled(false);
        
        
        
        
        if(evt.getButton()==1){
            int fila = jTable_Clientes.getSelectedRow();
            try {
                String sql = "SELECT * FROM cliente WHERE id="+jTable_Clientes.getValueAt(fila, 0);
                stm=conection.createStatement();
                ResultSet rs= stm.executeQuery(sql);
                rs.next();
                jTextField_name.setText(rs.getString("nombre"));
                jTextField_Cedula.setText(rs.getString("cedula"));
                jTextField_Telefono.setText(rs.getString("telefono"));
               // jTextField_fdn.setText(rs.getString("fdn"));
                jTextField_Peso.setText(rs.getString("peso"));
                jTextField_Altura.setText(rs.getString("altura"));
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }//GEN-LAST:event_jTable_ClientesMouseClicked
    }
    private void jButton_addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addClienteActionPerformed
        jButton_save.setEnabled(true);
        Allow();
    }//GEN-LAST:event_jButton_addClienteActionPerformed
    
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
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addCliente;
    private javax.swing.JButton jButton_del;
    private javax.swing.JButton jButton_mod;
    private javax.swing.JButton jButton_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Clientes;
    private javax.swing.JTextField jTextField_Altura;
    private javax.swing.JTextField jTextField_Cedula;
    private javax.swing.JTextField jTextField_Peso;
    private javax.swing.JTextField jTextField_Telefono;
    private com.toedter.calendar.JDateChooser jTextField_fdn;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
