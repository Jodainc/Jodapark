/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DB;
import Model.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JODA
 */
public class Update_user extends javax.swing.JFrame {

    /**
     * Creates new form alta_usuario
     */
    public Update_user() {
      
        initComponents();
        
    }
public int llenar_id(){  //añadimos una nueva ID a los parámetros 
     usuarios start = new usuarios();
       int newid=start.ultimo_id()+1;
      return newid;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        cmpContraseña = new javax.swing.JPasswordField();
        cmpNombre = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/createMen.png"))); // NOI18N
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 40, 30));
        jButton5.getAccessibleContext().setAccessibleDescription("");

        cmpContraseña.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmpContraseña.setForeground(new java.awt.Color(204, 204, 204));
        cmpContraseña.setBorder(null);
        cmpContraseña.setOpaque(false);
        getContentPane().add(cmpContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 170, 30));

        cmpNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmpNombre.setForeground(new java.awt.Color(204, 204, 204));
        cmpNombre.setBorder(null);
        cmpNombre.setOpaque(false);
        getContentPane().add(cmpNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/updaPer.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/loginButo.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 190, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/loginAdmin.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null,"-Si va a añadir un nuevo usuario rellene todos los campos\n"
                + "-Si va a modificar un registro Tiene que llenar el campo de Nombre por el que desee modificar\n"
                + "asi como los campos a modificar.\n-Si va a eliminar un registro Solo rellene el Nombre del registro a eliminar.\n\n"
                + " Cualquier duda consulte al administrador.","información",1);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
  new Login().setVisible(true);
       this.dispose();        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
                 try{
            usuarios usu = new usuarios(this.cmpNombre.getText());
            String  passoriginal= usu.getCostraseña();
            String  pass= new String(cmpContraseña.getPassword());
            System.out.println("Contraseña original: "+passoriginal+"   contraseña escrita: "+pass);
            if(pass.equals(passoriginal)){      //tipico ciclo de verificación de contraseña y usuario.
                //JOptionPane.showMessageDialog(null, "Exito", "sucess",2);
                new CambioValores().setVisible(true);
                this.dispose();
                System.out.println("Contraseña original: "+passoriginal+"   contraseña escrita: "+pass);
            }
            else{
               // reproducir_error();
                JOptionPane.showMessageDialog(null, "Datos Incorrectos", "Acceso denagado",2);
                //ojo que si pones la contraseña bien pero el user no tambien marca error ;)
        }
        }
        catch(Exception ex){
            ex.getMessage();
        }
      
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_user().setVisible(true);
     
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cmpContraseña;
    private javax.swing.JTextField cmpNombre;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
