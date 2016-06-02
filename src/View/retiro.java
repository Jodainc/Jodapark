package View;

import Model.Cajones;
import Model.CambioValor;
import Model.Clientes;
import Model.DB;
import Model.Horas;
import Model.Recibos;
import Model.javapdf;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JODA
 */
public class retiro extends javax.swing.JFrame {

    DefaultTableModel modelotabla = new DefaultTableModel();
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    DB cc = new DB();
    Connection conect = cc.GetConnection();
    Calendar re = Calendar.getInstance();
    File ruta = new File("");
    String rutarel = ruta.getAbsolutePath();
    int L;

    public retiro() {
        this.setUndecorated(true);
        this.setLocation(400, 100);
        initComponents();
        L = 1;
        this.tabla1.setModel(modelotabla);
        this.modelotabla.addColumn("Nombre");
        this.modelotabla.addColumn("Placa");
        this.modelotabla.addColumn("Vehiculo");
        this.modelotabla.addColumn("Cajon");
        this.combocajon.setModel(modelo);
        while (L < 12) {
            Cajones cajon = new Cajones(L);
            if (cajon.getEstado() == 1) {
                Object caj = cajon.getNumero();
                modelo.addElement(caj);
                L++;
            } else {
                L++;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        combocajon = new javax.swing.JComboBox();
        cmpTiempo = new javax.swing.JTextField();
        cmpPago = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmpTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cmpBusqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla1.setOpaque(false);
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabla1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 660, 130));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/butmapa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 380, -1));

        combocajon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", " " }));
        combocajon.setBorder(null);
        combocajon.setOpaque(false);
        combocajon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocajonItemStateChanged(evt);
            }
        });
        combocajon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combocajonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combocajonMouseClicked(evt);
            }
        });
        combocajon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocajonActionPerformed(evt);
            }
        });
        getContentPane().add(combocajon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 362, 640, 30));

        cmpTiempo.setText("determinado");
        cmpTiempo.setEnabled(false);
        cmpTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(cmpTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 410, 638, 35));

        cmpPago.setText("Calculada");
        cmpPago.setEnabled(false);
        cmpPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpPagoActionPerformed(evt);
            }
        });
        getContentPane().add(cmpPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 600, 35));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/labecajon.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 680, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/labetparque.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 670, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/labetpagar.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 670, -1));
        getContentPane().add(cmpTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 518, 640, 32));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/labetpago.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 670, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/bucobrar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 250, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/buback.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        cmpBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmpBusquedaKeyReleased(evt);
            }
        });
        getContentPane().add(cmpBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 51, 410, -1));

        jLabel7.setText("Horas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/Exit.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/flat/backSal.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 700, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void retiro_mapa(int caj) {
        this.combocajon.setSelectedItem(caj);
    }

    private String fecha() {
        String fecha = "" + Integer.toString(re.get(Calendar.YEAR)) + "/" + Integer.toString(re.get(Calendar.MONTH) + 1) + "/" + Integer.toString(re.get(Calendar.DATE)) + " " + Integer.toString(re.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(re.get((Calendar.MINUTE))) + ":" + Integer.toString(re.get((Calendar.SECOND)));
        return fecha;

    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new menu().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    private void cmpBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpBusquedaKeyReleased
        if (this.cmpBusqueda.getText().isEmpty()) {
            for (int i = modelotabla.getRowCount() - 1; i >= 0; i--) {
                modelotabla.removeRow(i);
            }
        } else {
            String letras = this.cmpBusqueda.getText();
            try {
                PreparedStatement ps = conect.prepareStatement("SELECT Nombre,Placa,Marca_modelo,Cajon_Numero from cliente where Placa like'%" + letras + "%'");
                ResultSet rs = ps.executeQuery();

                for (int i = modelotabla.getRowCount() - 1; i >= 0; i--) {
                    modelotabla.removeRow(i);
                }
                while (rs.next()) {
                    String Nombre = rs.getString("Nombre");
                    String Placa = rs.getString("Placa");
                    String Marca_modelo = rs.getString("Marca_modelo");
                    int Cajon_Numero = rs.getInt("Cajon_Numero");
                    Object fila[] = {Nombre, Placa, Marca_modelo, Cajon_Numero};
                    this.modelotabla.addRow(fila);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error: " + ex, "ERROR", 1);
            }

        }
    }//GEN-LAST:event_cmpBusquedaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new mapa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseReleased


    }//GEN-LAST:event_tabla1MouseReleased

    private void cmpTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpTiempoActionPerformed

    private void combocajonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocajonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocajonActionPerformed

    private void combocajonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocajonMouseReleased

    }//GEN-LAST:event_combocajonMouseReleased

    private void combocajonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocajonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combocajonMouseClicked

    private void combocajonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocajonItemStateChanged

        try {
            Clientes client = new Clientes(Integer.parseInt(this.combocajon.getSelectedItem().toString()));
            String llegada = client.getLlegada();
            System.out.println("Fecha llegada::" + llegada);
            String Salida = fecha();
            System.out.println("Fecha Salida::" + Salida);
            Horas cambio = new Horas();
            long diferencia = cambio.retornaDiferencia(llegada, Salida);
            long horas = cambio.retornaHoras(llegada, Salida);
            long minutos = cambio.retornaMinutos(llegada, Salida);
            long segundos = cambio.retornaSegundos(llegada, Salida);
            this.cmpTiempo.setText("" + diferencia);
            CambioValor vtar = new CambioValor(client.getTipove());
            int vpo = vtar.getValorpa();
            double valor = (double) vpo / 1440;
            double resultado = diferencia * valor;
            resultado = Redondear(resultado, 1);
            this.cmpPago.setText("" + resultado); //y el pago. diciéndole que solo ocupamos 2 cifras después del punto decimal.
        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }//GEN-LAST:event_combocajonItemStateChanged
    public static double Redondear(double numero, int digitos) {
        int cifras = (int) Math.pow(10, digitos);
        return Math.rint(numero * cifras) / cifras;
    }
    private void cmpPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpPagoActionPerformed

    }//GEN-LAST:event_cmpPagoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Clientes client = new Clientes(Integer.parseInt(this.combocajon.getSelectedItem().toString()));
        double tim = Double.parseDouble((this.cmpTiempo.getText()));
        double pag = Double.parseDouble((this.cmpPago.getText()));  //básicamente obtenemos los datos del cliente de acuerdo al cajón en el que esté ubicado.
        Cajones cajon = new Cajones(Integer.parseInt(this.combocajon.getSelectedItem().toString()));
        client.eliminar();
        cajon.eliminar();
        System.out.println("Cliente: " + client.getNombre() + " " + tim + "    y    " + pag + "   fecha:  " + fecha());
        //Recibos recibo= new Recibos(client.getNombre(),tim,pag,this.cmpTipo.getText(),fecha());
        //recibo.Guardar();   //guardamos el recibo con los datos actuales en nuestros campos.
        //Recibos rcpdf= new Recibos(client.getNombre());
        /*
        javapdf pdf = new javapdf();  //creamos un pdf con los datos del recibo creado.
        try {
            pdf.createPdf(String.valueOf(rcpdf.getFolio()),rcpdf.getCliente(),String.valueOf(rcpdf.getTiempo()),rcpdf.getTipo_pago(),String.valueOf(rcpdf.getImporte()),rcpdf.getFecha());
            System.out.println(rcpdf.getFolio());
        } catch (IOException ex) {
            Logger.getLogger(retiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(retiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.eliminar();
        try {
             File file = new File(rutarel+"\\Recibo"+rcpdf.getFolio()+".pdf"); //intentamos abrir el archivo pdf trás ser generado.
             Desktop.getDesktop().open(file);
            } catch(Exception e) {
               e.printStackTrace();
                }
         */
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(retiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retiro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cmpBusqueda;
    private javax.swing.JTextField cmpPago;
    private javax.swing.JTextField cmpTiempo;
    private javax.swing.JTextField cmpTipo;
    private javax.swing.JComboBox combocajon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
