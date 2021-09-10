/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aras;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author mjgod
 */
public class RegistrarAlumnos1 extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarAlumnos1
     */
    public RegistrarAlumnos1() {
        initComponents();
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }
    
    //Reemplazar el icono de java por default
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/cuatroVientos.jpg"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_nombre9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información del Alumno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre y Apellido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 210, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txt_nombre1.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lugar y fecha de nacimiento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txt_nombre2.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Domicilio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txt_nombre3.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Localidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        txt_nombre4.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre4.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre de la madre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        txt_nombre5.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre5.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 210, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        txt_nombre6.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre6.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 210, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre del padre:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        txt_nombre8.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre8.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 210, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DNI:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        txt_nombre9.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre9.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 210, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono de contacto:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        txt_nombre10.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre10.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 210, -1));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Siguiente >");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 140, 50));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RegistrarAlumnos4 registrarAlumnos4 = new RegistrarAlumnos4();
        registrarAlumnos4.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAlumnos1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_nombre10;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_nombre3;
    private javax.swing.JTextField txt_nombre4;
    private javax.swing.JTextField txt_nombre5;
    private javax.swing.JTextField txt_nombre6;
    private javax.swing.JTextField txt_nombre8;
    private javax.swing.JTextField txt_nombre9;
    // End of variables declaration//GEN-END:variables
}
