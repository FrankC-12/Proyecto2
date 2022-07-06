/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventana;

import Controller.ReadFile;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import main.Node;

/**
 *
 * @author giubo
 */
public class MenuMain extends javax.swing.JFrame {
    static ReadFile reader = new ReadFile();

  

    /**
     * Creates new form Menu
     */
    public MenuMain() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

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
        buscar_por_autor = new javax.swing.JButton();
        buscar_por_clave = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        analizar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar_por_autor.setBackground(new java.awt.Color(255, 152, 51));
        buscar_por_autor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscar_por_autor.setText("Buscar Investigaciones por Autor: ");
        buscar_por_autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_por_autorActionPerformed(evt);
            }
        });
        jPanel1.add(buscar_por_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        buscar_por_clave.setBackground(new java.awt.Color(255, 153, 51));
        buscar_por_clave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscar_por_clave.setText("Buscar Investigaciones por palabra clave");
        jPanel1.add(buscar_por_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        analizar.setBackground(new java.awt.Color(255, 153, 51));
        analizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        analizar.setText("Analizar Resumen");
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });
        jPanel1.add(analizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        agregar.setBackground(new java.awt.Color(255, 153, 51));
        agregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        agregar.setText("Agregar Resumen");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 204, 102));
        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 3, 18)); // NOI18N
        jLabel2.setText("BIENVENIDO A METRO-MENDELEY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 330, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textos-argumentativos.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed

    }//GEN-LAST:event_analizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        try {
          
            reader.readFile();

            JOptionPane.showMessageDialog(null, "Resumen agregado con exito!");
            
            
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el txt");
        }


    }//GEN-LAST:event_agregarActionPerformed

    private void buscar_por_autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_por_autorActionPerformed
        Autor b = new Autor();
        this.setVisible(false);
        b.setVisible(true);
    }//GEN-LAST:event_buscar_por_autorActionPerformed

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
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton analizar;
    private javax.swing.JButton buscar_por_autor;
    private javax.swing.JButton buscar_por_clave;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}