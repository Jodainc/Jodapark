package View;
import Model.CambioValor;
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
public class CambioValores extends javax.swing.JFrame {
    /**
     * Creates new form alta_usuario
     */
    public CambioValores() {
        initComponents();
    }
public int llenar_id(){  //añadimos una nueva ID a los parámetros 
     CambioValor start = new CambioValor();
       int newid=start.ultimo_id()+1;
      return newid;
}
public int Saber_id(){  //añadimos una nueva ID a los parámetros 
     CambioValor start = new CambioValor();
       int newid=start.ultimo_id();
      return newid;
}
public int Sabervar_id(){  //añadimos una nueva ID a los parámetros 
     CambioValor start = new CambioValor();
       int newid=start.ultiValor_id();
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

        cmpPuesto = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        cmpNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmpContraseña = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmpPuesto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmpPuesto.setForeground(new java.awt.Color(204, 204, 204));
        cmpPuesto.setBorder(null);
        cmpPuesto.setOpaque(false);
        getContentPane().add(cmpPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 440, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/createMen.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 40, 30));
        jButton5.getAccessibleContext().setAccessibleDescription("");

        cmpNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmpNombre.setForeground(new java.awt.Color(204, 204, 204));
        cmpNombre.setBorder(null);
        CambioValor a = new CambioValor();
        cmpNombre.setText(""+a.ultimo_id());
        cmpNombre.setOpaque(false);
        getContentPane().add(cmpNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 228, 440, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/createCan.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 435, 220, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        cmpContraseña.setOpaque(false);
        CambioValor a1 = new CambioValor();
        cmpContraseña.setText(""+a1.ultimoValor_id());
        getContentPane().add(cmpContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 440, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Puesto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, -1, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/createGuar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 435, 220, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/updaPer.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/Createpro.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     //se actualiza el usuario actual escrito
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cmpNombre.getText().equals("")||cmpContraseña.getText().equals("")||cmpPuesto.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No se puede guardar faltan datos", "Verifique",1);
        }else{
            int ultimo = Sabervar_id();
        System.out.println("este es el ultimo"+ultimo);
        CambioValor cambi = new CambioValor(llenar_id(),Integer.parseInt(this.cmpNombre.getText()),Float.parseFloat(this.cmpContraseña.getText()),Float.parseFloat(this.cmpPuesto.getText()));
        cambi.setIdUsuario(llenar_id());
        cambi.setCajon(Integer.parseInt(this.cmpNombre.getText()));
        cambi.setValorpa(Float.parseFloat(this.cmpContraseña.getText()));
        cambi.actualizar(ultimo);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
                //eliminamos el usuario escrito
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        usuarios userelim= new usuarios(llenar_id()-1,this.cmpNombre.getText(),this.cmpContraseña.getText(),this.cmpPuesto.getText());
        userelim.eliminar(this.cmpNombre.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        
        new Update_user().setVisible(true);
       this.dispose();        
        /* JOptionPane.showMessageDialog(null,"-Si va a añadir un nuevo usuario rellene todos los campos\n"
                + "-Si va a modificar un registro Tiene que llenar el campo de Nombre por el que desee modificar\n"
                + "asi como los campos a modificar.\n-Si va a eliminar un registro Solo rellene el Nombre del registro a eliminar.\n\n"
                + " Cualquier duda consulte al administrador.","información",1);   
        */
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
                    //creamos un nuevo usuario a partir de los datos que estén en los campos de texto.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(this.cmpNombre.getText().equals("")||this.cmpContraseña.getText().equals("")||this.cmpPuesto.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Campos incompletos","error",1);
        }else{
        usuarios usernew = new usuarios();
       usernew.setIdUsuario(llenar_id());
       usernew.setNombre(this.cmpNombre.getText());
       usernew.setConstraseña(this.cmpContraseña.getText());
       usernew.setPuesto(this.cmpPuesto.getText());
       usernew.Guardar();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new Login().setVisible(true);
       this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
  new Login().setVisible(true);
       this.dispose();        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(CambioValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambioValores().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cmpContraseña;
    private javax.swing.JTextField cmpNombre;
    private javax.swing.JTextField cmpPuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
