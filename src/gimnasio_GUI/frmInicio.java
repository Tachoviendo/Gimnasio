

package gimnasio_GUI;

import ConMySql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;




public class frmInicio extends javax.swing.JFrame {
    
    Statement stm;
    java.sql.Connection conection;
    public static String usugeneral;

    
    public frmInicio() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public boolean existeusuario(String usuario, String xpass){
        
        try {
            conection = Connection.getConection();
            String sql = "SELECT Nombre_Usuario, Pass_Usuario FROM usuario WHERE Nombre_Usuario='"+usuario+"'and Pass_Usuario='"+xpass+"'";
            stm = conection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                usugeneral=usuario;                
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_iniSesion = new javax.swing.JButton();
        jTextField_usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField_ini = new javax.swing.JPasswordField();
        jButton_register = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton_iniSesion.setBackground(new java.awt.Color(255, 0, 0));
        jButton_iniSesion.setFont(new java.awt.Font("Syntax LT Std Black", 0, 18)); // NOI18N
        jButton_iniSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_iniSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_Inisesion.png"))); // NOI18N
        jButton_iniSesion.setText("Iniciar Sesión");
        jButton_iniSesion.setAlignmentY(0.0F);
        jButton_iniSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        jButton_iniSesion.setBorderPainted(false);
        jButton_iniSesion.setContentAreaFilled(false);
        jButton_iniSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iniSesion.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton_iniSesion.setDefaultCapable(false);
        jButton_iniSesion.setDisplayedMnemonicIndex(0);
        jButton_iniSesion.setFocusable(false);
        jButton_iniSesion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton_iniSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_iniSesion.setIconTextGap(0);
        jButton_iniSesion.setMargin(new java.awt.Insets(5, 14, 3, 14));
        jButton_iniSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_iniSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_iniSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_iniSesionMouseExited(evt);
            }
        });
        jButton_iniSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iniSesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Syntax LT Std UltraBlack", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Usuario: ");

        jButton_register.setFont(new java.awt.Font("Syntax LT Std UltraBlack", 0, 18)); // NOI18N
        jButton_register.setForeground(new java.awt.Color(255, 0, 0));
        jButton_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_registrarse.png"))); // NOI18N
        jButton_register.setBorder(null);
        jButton_register.setBorderPainted(false);
        jButton_register.setContentAreaFilled(false);
        jButton_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_registerMouseExited(evt);
            }
        });
        jButton_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registerActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_fondo_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Syntax LT Std UltraBlack", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField_ini)
                            .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButton_iniSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton_register)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jButton_register)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_iniSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registerActionPerformed
        new frmRegister().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_registerActionPerformed

    private void jButton_registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_registerMouseExited
        jButton_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_registrarse.png")));
    }//GEN-LAST:event_jButton_registerMouseExited

    private void jButton_registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_registerMouseEntered
        jButton_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_registrarse2.png")));
    }//GEN-LAST:event_jButton_registerMouseEntered

    private void jButton_iniSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iniSesionActionPerformed
        String pass = new String(jPasswordField_ini.getPassword());
        
        
        
        
        
        
        if (existeusuario(jTextField_usuario.getText(), pass)){
            JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso!.");
            new frmMain().setVisible(true);
            this.dispose();
        }else{
            int aux =0;
            String datos[] = {jTextField_usuario.getText(),  String.valueOf(jPasswordField_ini.getPassword())};
            String names[] = {"Nombre de Usuario", "Contraseña"};
            String sentencia = "Los siguientes campos se encuentran vacíos: ";
        
            for (int i=0; i<2; i++){
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
            if (aux>0 ){
            JOptionPane.showMessageDialog(null, (sentencia+"."));
            }
            else{
                JOptionPane.showMessageDialog(null, "Nombre de usuario y/o contraseña incorrecta.");
                jTextField_usuario.setText("");
                jPasswordField_ini.setText("");
            }
            
            

        }
    }//GEN-LAST:event_jButton_iniSesionActionPerformed

    private void jButton_iniSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_iniSesionMouseExited
        jButton_iniSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_Inisesion.png")));
    }//GEN-LAST:event_jButton_iniSesionMouseExited

    private void jButton_iniSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_iniSesionMouseEntered
        jButton_iniSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/frmInicio_Inisesion2.png")));
    }//GEN-LAST:event_jButton_iniSesionMouseEntered

    /*
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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_iniSesion;
    private javax.swing.JButton jButton_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_ini;
    private javax.swing.JTextField jTextField_usuario;
    // End of variables declaration//GEN-END:variables
}
