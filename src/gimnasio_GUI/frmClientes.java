
package gimnasio_GUI;

import ConMySql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_fdn = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jButton_addCliente = new javax.swing.JButton();
        jTextField_Cedula = new javax.swing.JTextField();
        jButton_save = new javax.swing.JButton();
        jTextField_Telefono = new javax.swing.JTextField();
        jButton_mod = new javax.swing.JButton();
        jTextField_Peso = new javax.swing.JTextField();
        jButton_del = new javax.swing.JButton();
        jTextField_Altura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_Clientes.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Clientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_Clientes.setForeground(new java.awt.Color(0, 0, 0));
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
        jTable_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Clientes.setGridColor(new java.awt.Color(249, 171, 171));
        jTable_Clientes.setSelectionBackground(new java.awt.Color(255, 139, 139));
        jTable_Clientes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_Clientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Clientes.setShowGrid(true);
        jTable_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Clientes);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_cedula.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_telefono.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_peso.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_altura.png"))); // NOI18N

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jButton_addCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add.png"))); // NOI18N
        jButton_addCliente.setBorderPainted(false);
        jButton_addCliente.setContentAreaFilled(false);
        jButton_addCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_addCliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_addCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_addClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_addClienteMouseExited(evt);
            }
        });
        jButton_addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addClienteActionPerformed(evt);
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

        jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod.png"))); // NOI18N
        jButton_mod.setContentAreaFilled(false);
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

        jTextField_Altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AlturaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_nombre.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_titulo.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmClientes_fdn.png"))); // NOI18N
        jLabel4.setText("Fecha de Nacimiento:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Telefono))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_fdn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel2)
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(16, 16, 16))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField_Altura)
                                        .addGap(4, 4, 4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_name, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_Cedula))
                                        .addGap(3, 3, 3))
                                    .addComponent(jTextField_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_mod)
                            .addComponent(jButton_addCliente)
                            .addComponent(jButton_del)
                            .addComponent(jButton_save)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton_back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_addCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_del, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_save)
                        .addGap(183, 183, 183))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_fdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_Altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addComponent(jButton_back)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        int aux =0;
        String date = String.valueOf(jTextField_fdn.getDate());
        System.out.println(date.length());
        String datos[] = {jTextField_name.getText(), jTextField_Cedula.getText(), jTextField_Telefono.getText(),  jTextField_Peso.getText(), jTextField_Altura.getText()};
        String names[] = {"Nombre", "Cédula", " Teléfono", "Peso", "Altura"};
        String sentencia = "Los siguientes campos se encuentran vacíos: ";
        
        for (int i=0; i<5; i++){
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
        if(date.length() == 4){
            sentencia +=(", Fecha de nacimiento");
        }
        
        if (aux>0 ){
            JOptionPane.showMessageDialog(null, (sentencia+"."));
        }
        else{
            try {
                int fila;
                String sql;

                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar los datos del registro?",
                "Registro actualizado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    fila =jTable_Clientes.getSelectedRow();
                    String fecha = convertTostring(jTextField_fdn.getDate());
                    sql="UPDATE `cliente` SET `id`='"+jTable_Clientes.getValueAt(fila, 0)+"',`nombre`='"+jTextField_name.getText()+"',`cedula`='"+jTextField_Cedula.getText()+
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
            } 
            catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
            }
            
        }
        
        
    }//GEN-LAST:event_jButton_modActionPerformed

    private void jButton_modMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_modMouseExited
        if(jButton_mod.isEnabled()){
            jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod.png")));
        }
        
    }//GEN-LAST:event_jButton_modMouseExited

    private void jButton_modMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_modMouseEntered
        if(jButton_mod.isEnabled()){
            jButton_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_mod2.png")));
        }
        
        
    }//GEN-LAST:event_jButton_modMouseEntered

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        int aux =0;
        String date = String.valueOf(jTextField_fdn.getDate());
        System.out.println(date.length());
        String datos[] = {jTextField_name.getText(), jTextField_Cedula.getText(), jTextField_Telefono.getText(),  jTextField_Peso.getText(), jTextField_Altura.getText()};
        String names[] = {"Nombre", "Cédula", " Teléfono", "Peso", "Altura"};
        String sentencia = "Los siguientes campos se encuentran vacíos: ";
        
        for (int i=0; i<5; i++){
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
        if(date.length() == 4){
            sentencia +=(", Fecha de nacimiento");
        }
        
        if (aux>0 ){
            JOptionPane.showMessageDialog(null, (sentencia+"."));
        }
        else{
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
            
        }
            
        
        
        
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseExited
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar.png")));
    }//GEN-LAST:event_jButton_saveMouseExited

    private void jButton_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseEntered
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_guardar2.png")));
    }//GEN-LAST:event_jButton_saveMouseEntered

    private void jButton_addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addClienteActionPerformed
        jButton_save.setEnabled(true);
        Allow();
    }//GEN-LAST:event_jButton_addClienteActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        jButton_save.setEnabled(true);
        Allow();
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jTable_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientesMouseClicked
        Allow();

        jButton_del.setEnabled(true);
        jButton_mod.setEnabled(true);
        jButton_save.setEnabled(false);

        if(evt.getButton()==1){
            int fila = jTable_Clientes.getSelectedRow();
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-d");
                String sql = "SELECT * FROM cliente WHERE id="+jTable_Clientes.getValueAt(fila, 0);
                stm=conection.createStatement();
                ResultSet rs= stm.executeQuery(sql);
                rs.next();
                
                jTextField_name.setText(rs.getString("nombre"));
                jTextField_Cedula.setText(rs.getString("cedula"));
                jTextField_Telefono.setText(rs.getString("telefono"));
                //convierte el string que gaurdamos en la base de datos 
                Date DatePiola = df.parse(rs.getString("fdn"));
                jTextField_fdn.setDate(DatePiola);
                jTextField_Peso.setText(rs.getString("peso"));
                jTextField_Altura.setText(rs.getString("altura"));

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTable_ClientesMouseClicked

    private void jButton_addClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addClienteMouseExited
        jButton_addCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add.png")));        
    }//GEN-LAST:event_jButton_addClienteMouseExited

    private void jButton_addClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addClienteMouseEntered
        jButton_addCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_add2.png")));
    }//GEN-LAST:event_jButton_addClienteMouseEntered

    private void jButton_delMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_delMouseExited
        jButton_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete.png")));
    }//GEN-LAST:event_jButton_delMouseExited

    private void jButton_delMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_delMouseEntered
        jButton_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frm_delete2.png")));
    }//GEN-LAST:event_jButton_delMouseEntered

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

    private void jTextField_AlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_AlturaActionPerformed
      
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
    private javax.swing.JButton jButton_back;
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
    private javax.swing.JPanel jPanel1;
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
