/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gimnasio_GUI;

import ConMySql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Tacho
 */
public class frmProfesores extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    Statement stm;
    java.sql.Connection conection;

   
    public frmProfesores() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        CargarProfesor();
        configTabla();
        
        jButton_del.setEnabled(false);
        jButton_save.setEnabled(false);
        jButton_mod.setEnabled(false);
        
        jTextField_Cedula.setEditable(false);
        jTextField_Espe.setEditable(false);
        jTextField_name.setEditable(false);
        jTextField_Telefono.setEditable(false);
        
        
    }
    private void Clean(){
        jTextField_Cedula.setText(null);
        jTextField_name.setText(null);
        jTextField_Telefono.setText(null);
        jTextField_Espe.setText(null);
        jTextField_name.requestFocus();
    }
    
     private void Allow(){
        jTextField_Cedula.setEditable(true);
        jTextField_Espe.setEditable(true);
        jTextField_Telefono.setEditable(true);
        jTextField_name.setEditable(true);
        jTextField_name.requestFocus();
    }
    
    private void configTabla(){
        jtProfesores.setAutoResizeMode(0);
        TableColumnModel columnModel = jtProfesores.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(375);
        columnModel.getColumn(1).setPreferredWidth(375);
        columnModel.getColumn(2).setPreferredWidth(375);
        columnModel.getColumn(3).setPreferredWidth(375);
        columnModel.getColumn(4).setPreferredWidth(450);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        jtProfesores.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtProfesores.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtProfesores.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtProfesores.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtProfesores.getColumnModel().getColumn(4).setCellRenderer(tcr);
    } 
    
    private void CargarProfesor(){
        jtProfesores.setAutoResizeMode(0);
        try {
            conection = Connection.getConection();
            String[] titulos ={"ID Profesor","Nombre", "Cédula","Teléfono","Especialidad"};
            String sql="SELECT * FROM profesor";
            modelo= new DefaultTableModel(null, titulos);
            stm = conection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            
            String[] fila = new String[6];
            
            while(rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("nombre");
                fila[2]=rs.getString("cedula");
                fila[3]=rs.getString("telefono");
                fila[4]=rs.getString("especialidad");
                modelo.addRow(fila);
            }
            jtProfesores.setModel(modelo);
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
        jTextField_Espe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_addProfesor = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_mod = new javax.swing.JButton();
        jButton_del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProfesores = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Cédula:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Especialidad");

        jButton_addProfesor.setText("Agregar");
        jButton_addProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addProfesorActionPerformed(evt);
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

        jtProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jtProfesores.setCellSelectionEnabled(false);
        jtProfesores.setPreferredSize(new java.awt.Dimension(375, 80));
        jtProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProfesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProfesores);

        jLabel7.setText("PROFESORES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_Espe)
                                .addComponent(jTextField_Telefono)
                                .addComponent(jTextField_Cedula)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_del)
                            .addGap(41, 41, 41)
                            .addComponent(jButton_addProfesor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_mod)
                            .addGap(41, 41, 41)
                            .addComponent(jButton_save))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
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
                        .addGap(90, 90, 90)
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Espe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_addProfesor)
                            .addComponent(jButton_save)
                            .addComponent(jButton_mod)
                            .addComponent(jButton_del))))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        
        
        try {
            String sql = "INSERT INTO `profesor` (id, `cedula`, `telefono`, `especialidad`, `nombre`) VALUES (null,?,?,?,?)";
            PreparedStatement ps =conection.prepareCall(sql);
            
            ps.setString(1, jTextField_Cedula.getText());
            ps.setString(2, jTextField_Telefono.getText());
            ps.setString(3, jTextField_Espe.getText());
            ps.setString(4, jTextField_name.getText());
            int n=ps.executeUpdate();
                        
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar, verifique "+e.getMessage());
        }
        CargarProfesor();
        Clean();
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_delActionPerformed
        try {
           int fila=0;
           String sql;
           if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar el registro?",
                "Eliminación Registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                fila =jtProfesores.getSelectedRow();
                sql = "DELETE FROM profesor WHERE id="+jtProfesores.getValueAt(fila, 0);
                stm=conection.createStatement();
                int n = stm.executeUpdate(sql);
                if(n>0){
                    CargarProfesor();
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
                    fila =jtProfesores.getSelectedRow();
                    sql="UPDATE `profesor` SET `id`='"+jtProfesores.getValueAt(fila, 0)+"',`cedula`='"+jTextField_Cedula.getText()+"',`telefono`='"+jTextField_Telefono.getText()+
                        "',`especialidad`='"+jTextField_Espe.getText()+
                        "',`nombre`='"+jTextField_name.getText()+
                        "'WHERE "+jtProfesores.getValueAt(fila, 0)+"";
                    PreparedStatement ps = conection.prepareCall(sql);
                    int n= ps.executeUpdate();
                if(n>0){
                    CargarProfesor();
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
            }    
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
        }
    }//GEN-LAST:event_jButton_modActionPerformed

    private void jtProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProfesoresMouseClicked
        Allow();
        
        jButton_del.setEnabled(true);
        jButton_mod.setEnabled(true);
        jButton_save.setEnabled(false);
        
       
        
        
        if(evt.getButton()==1){
            int fila = jtProfesores.getSelectedRow();
            try {
                String sql = "SELECT * FROM profesor WHERE id="+jtProfesores.getValueAt(fila, 0);
                stm=conection.createStatement();
                ResultSet rs= stm.executeQuery(sql);
                rs.next();
                jTextField_name.setText(rs.getString("nombre"));
                jTextField_Cedula.setText(rs.getString("cedula"));
                jTextField_Telefono.setText(rs.getString("telefono"));
                jTextField_Espe.setText(rs.getString("especialidad"));
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jtProfesoresMouseClicked

    private void jButton_addProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addProfesorActionPerformed
        jButton_save.setEnabled(true);
        Allow();
        
        
    }//GEN-LAST:event_jButton_addProfesorActionPerformed

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
            java.util.logging.Logger.getLogger(frmProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addProfesor;
    private javax.swing.JButton jButton_del;
    private javax.swing.JButton jButton_mod;
    private javax.swing.JButton jButton_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Cedula;
    private javax.swing.JTextField jTextField_Espe;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTable jtProfesores;
    // End of variables declaration//GEN-END:variables
}
