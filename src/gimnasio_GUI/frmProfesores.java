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
    String espe;
    

   
    public frmProfesores() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        CargarProfesor();
        configTabla();
        
        jButton_del.setEnabled(false);
        jButton_save.setEnabled(false);
        jButton_mod.setEnabled(false);
        
        jTextField_Cedula.setEditable(false);
        jComboBox1.setEditable(false);
        jTextField_name.setEditable(false);
        jTextField_Telefono.setEditable(false);
        
        
    }
    private void Clean(){
        jTextField_Cedula.setText(null);
        jTextField_name.setText(null);
        jTextField_Telefono.setText(null);
        jComboBox1.setSelectedItem(0);
        jTextField_name.requestFocus();
    }
    
    private void Allow(){
        jTextField_Cedula.setEditable(true);
        jComboBox1.setEditable(true);
        jTextField_Telefono.setEditable(true);
        jTextField_name.setEditable(true);
        jTextField_name.requestFocus();
    }
    
    public static String IdEspe(String a){
            String especialidades[] = {"Seleccionar especialidad", "Pilates", "Musculación", "CrossFit", "Cardiovasculación"};
            String ide = null;
            for (int i =0; i<=especialidades.length; i++){
                if (especialidades[i].equals(a)){
                    ide = String.valueOf(i);
                    break;
                
                }
            }
            
        
            
            return ide;
        }
   
    private void configTabla(){
        jtProfesores.setAutoResizeMode(0);
        TableColumnModel columnModel = jtProfesores.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(150);
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

        jButton_addCliente = new javax.swing.JButton();
        jButton_mod1 = new javax.swing.JButton();
        jButton_del1 = new javax.swing.JButton();
        jButton_save1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_Cedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProfesores = new javax.swing.JTable();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_addProfesor = new javax.swing.JButton();
        jButton_mod = new javax.swing.JButton();
        jButton_del = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_back = new javax.swing.JButton();

        jButton_addCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add.png"))); // NOI18N
        jButton_addCliente.setBorderPainted(false);
        jButton_addCliente.setContentAreaFilled(false);
        jButton_addCliente.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton_mod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod.png"))); // NOI18N
        jButton_mod1.setContentAreaFilled(false);
        jButton_mod1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton_del1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete.png"))); // NOI18N
        jButton_del1.setBorderPainted(false);
        jButton_del1.setContentAreaFilled(false);
        jButton_del1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton_save1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar.png"))); // NOI18N
        jButton_save1.setBorderPainted(false);
        jButton_save1.setContentAreaFilled(false);
        jButton_save1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jtProfesores.setSelectionForeground(new java.awt.Color(255, 122, 122));
        jtProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProfesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProfesores);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmProfesores_titulo.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_nombre.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_cedula.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_telefono.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmProfesores_tel.png"))); // NOI18N

        jButton_addProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add.png"))); // NOI18N
        jButton_addProfesor.setBorderPainted(false);
        jButton_addProfesor.setContentAreaFilled(false);
        jButton_addProfesor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_addProfesor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_addProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_addProfesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_addProfesorMouseExited(evt);
            }
        });
        jButton_addProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addProfesorActionPerformed(evt);
            }
        });

        jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod.png"))); // NOI18N
        jButton_mod.setContentAreaFilled(false);
        jButton_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_mod.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_mod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_modMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_modMouseExited(evt);
            }
        });
        jButton_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modActionPerformed(evt);
            }
        });

        jButton_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete.png"))); // NOI18N
        jButton_del.setBorderPainted(false);
        jButton_del.setContentAreaFilled(false);
        jButton_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_del.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_delMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_delMouseExited(evt);
            }
        });
        jButton_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_delActionPerformed(evt);
            }
        });

        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar.png"))); // NOI18N
        jButton_save.setBorderPainted(false);
        jButton_save.setContentAreaFilled(false);
        jButton_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_save.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_saveMouseExited(evt);
            }
        });
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar especialidad", "Pilates", "Musculación", "CrossFit", "Cardiovasculación", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_back.png"))); // NOI18N
        jButton_back.setBorderPainted(false);
        jButton_back.setContentAreaFilled(false);
        jButton_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_back.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_backMouseExited(evt);
            }
        });
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_mod)
                            .addComponent(jButton_addProfesor)
                            .addComponent(jButton_del)
                            .addComponent(jButton_save)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton_back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_addProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_mod)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextField_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton_del, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_back, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                int id = Integer.parseInt(IdEspe(rs.getString("especialidad")));
                jComboBox1.setSelectedIndex(id);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jtProfesoresMouseClicked

    private void jButton_addProfesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addProfesorMouseEntered
        jButton_addProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add2.png")));
    }//GEN-LAST:event_jButton_addProfesorMouseEntered

    private void jButton_addProfesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addProfesorMouseExited
        jButton_addProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add.png")));
    }//GEN-LAST:event_jButton_addProfesorMouseExited

    private void jButton_addProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addProfesorActionPerformed
        jButton_save.setEnabled(true);
        Allow();
    }//GEN-LAST:event_jButton_addProfesorActionPerformed

    private void jButton_modMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_modMouseEntered
        jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod2.png")));
    }//GEN-LAST:event_jButton_modMouseEntered

    private void jButton_modMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_modMouseExited
        jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod.png")));
    }//GEN-LAST:event_jButton_modMouseExited

    private void jButton_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modActionPerformed
        int aux =0;
        String datos[] = {jTextField_name.getText(), jTextField_Cedula.getText(), jTextField_Telefono.getText()};
        String names[] = {"Nombre", "Cédula", " Teléfono"};
        String sentencia = "Los siguientes campos se encuentran vacíos: ";
        
        for (int i=0; i<3; i++){
           if (datos[i].length() ==0){
                if (aux==0){
                    sentencia += names[i];
                    aux++;
                }
                else{
                    sentencia += (", "+names[i]);
                    aux++;
                }
                
            }
        }
        espe = String.valueOf(jComboBox1.getSelectedItem());
        if (aux>0 && espe =="Seleccionar especialidad" ){
            JOptionPane.showMessageDialog(null, (sentencia+",  Especialidad."));
        }
        else if (aux >0){
                JOptionPane.showMessageDialog(null, sentencia+".");
        }
        else{
            try {
                int fila;
                String sql;

                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar los datos del registro?",
                "Registro actualizado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    fila =jtProfesores.getSelectedRow();
            
                    sql="UPDATE `profesor` SET `id`='"+jtProfesores.getValueAt(fila, 0)+"',`cedula`='"+jTextField_Cedula.getText()+"',`telefono`='"+jTextField_Telefono.getText()+
                    "',`especialidad`='"+espe+
                    "',`nombre`='"+jTextField_name.getText()+
                    "'WHERE "+jtProfesores.getValueAt(fila, 0)+"";
                    PreparedStatement ps = conection.prepareCall(sql);
                    int n= ps.executeUpdate();
                    if(n>0){
                        CargarProfesor();
                        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    }
                }
            } 
            catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
            }
                
            }
        
        
    }//GEN-LAST:event_jButton_modActionPerformed

    private void jButton_delMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_delMouseEntered
        jButton_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete2.png")));
    }//GEN-LAST:event_jButton_delMouseEntered

    private void jButton_delMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_delMouseExited
        jButton_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete.png")));
    }//GEN-LAST:event_jButton_delMouseExited

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

    private void jButton_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseEntered
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar2.png")));
    }//GEN-LAST:event_jButton_saveMouseEntered

    private void jButton_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseExited
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar.png")));
    }//GEN-LAST:event_jButton_saveMouseExited

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        int aux =0;
        String datos[] = {jTextField_name.getText(), jTextField_Cedula.getText(), jTextField_Telefono.getText()};
        String names[] = {"Nombre", "Cédula", " Teléfono"};
        String sentencia = "Los siguientes campos se encuentran vacíos: ";
        
        for (int i=0; i<3; i++){
           if (datos[i].length() ==0){
                if (aux==0){
                    sentencia += names[i];
                    aux++;
                }
                else{
                    sentencia += (", "+names[i]);
                    aux++;
                }
                
            }
        }
        espe = String.valueOf(jComboBox1.getSelectedItem());
        if (aux>0 && espe =="Seleccionar especialidad" ){
            JOptionPane.showMessageDialog(null, (sentencia+",  Especialidad."));
        }
        else if (aux >0){
                JOptionPane.showMessageDialog(null, sentencia+".");
        }
        else{
            try {
            String sql = "INSERT INTO `profesor` (id, `cedula`, `telefono`, `especialidad`, `nombre`) VALUES (null,?,?,?,?)";
            PreparedStatement ps =conection.prepareCall(sql);
            
            
            
            ps.setString(1, jTextField_Cedula.getText());
            ps.setString(2, jTextField_Telefono.getText());
            ps.setString(3, espe);
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
            
        }
        
        
        
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_backMouseEntered
        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_back2.png")));
    }//GEN-LAST:event_jButton_backMouseEntered

    private void jButton_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_backMouseExited
        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_back.png")));
    }//GEN-LAST:event_jButton_backMouseExited

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        new frmMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

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
    private javax.swing.JButton jButton_addCliente;
    private javax.swing.JButton jButton_addProfesor;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_del;
    private javax.swing.JButton jButton_del1;
    private javax.swing.JButton jButton_mod;
    private javax.swing.JButton jButton_mod1;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_save1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Cedula;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTable jtProfesores;
    // End of variables declaration//GEN-END:variables
}
