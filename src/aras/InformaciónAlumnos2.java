package aras;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author mjgod
 */
public class InformaciónAlumnos2 extends javax.swing.JFrame {
    
    public static String nombre_escuela, numero_escuela, repitio, grado_repetido, grado, genero;
    //String user_update = "";
    int user_update;
    public static InformaciónAlumnos3 informacionAlumnos3 = new InformaciónAlumnos3();
    
    public InformaciónAlumnos2() {
        initComponents();
        user_update = GestionarAlumnos.user_update;
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Gestión de alumnos");
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select * from alumnos where dni = '" + user_update + "'"); //selecciono los datos del usuario elegido
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                //ID = rs.getInt("id");
                //Realizo el vaciado de datos en los jtextfield.
                txt_nombre_escuela.setText(rs.getString("nombre_escuela"));
                txt_numero_escuela.setText(rs.getString("numero_escuela"));
                
                
                jComboBox_grado_repetido.setSelectedItem(rs.getString("grado_repetido"));
                //Ahora hay 2 jcomboBox (tengo que pasarle a cual corresponde)
                //jComboBox_grado.setSelectedItem(rs.getString("grado"));
                
                
                if("SI".equals(rs.getString("repitio"))){
                        jRadioButton_repitio.setSelected(true);
                } else {
                    jRadioButton4.setSelected(true);
                }
                
                if("Masculino".equals(rs.getString("genero"))){
                        jRadioButton_hombre.setSelected(true);
                        jComboBox_grado1.setSelectedItem(rs.getString("grado"));
                        jComboBox_grado.disable();
                } else {
                    if("Femenino".equals(rs.getString("genero"))) {
                        jRadioButton_mujer.setSelected(true);
                        jComboBox_grado.setSelectedItem(rs.getString("grado"));
                        jComboBox_grado1.disable();
                    }
                }
                
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar usuario. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre_escuela = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_numero_escuela = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton_repitio = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox_grado_repetido = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton_hombre = new javax.swing.JRadioButton();
        jRadioButton_mujer = new javax.swing.JRadioButton();
        jLabel_genero = new javax.swing.JLabel();
        jComboBox_grado1 = new javax.swing.JComboBox<>();
        jComboBox_grado = new javax.swing.JComboBox<>();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información Escolar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de la escuela:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txt_nombre_escuela.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre_escuela.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre_escuela.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre_escuela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre_escuela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre_escuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 210, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nº de la escuela:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txt_numero_escuela.setBackground(new java.awt.Color(51, 102, 255));
        txt_numero_escuela.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_numero_escuela.setForeground(new java.awt.Color(255, 255, 255));
        txt_numero_escuela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_escuela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numero_escuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 210, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("¿Qué grado repitió?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Repitió alguna vez?");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        buttonGroup2.add(jRadioButton_repitio);
        jRadioButton_repitio.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_repitio.setText("SI");
        jRadioButton_repitio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_repitioItemStateChanged(evt);
            }
        });
        getContentPane().add(jRadioButton_repitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("NO");
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("< Anterior");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 140, 50));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Siguiente >");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 140, 50));

        jComboBox_grado_repetido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1º grado", "2º grado", "3º grado", "4º grado", "5º grado", "6º grado", "7º grado", "1º año", "2º año", "3º año", "4º año", "5º año" }));
        jComboBox_grado_repetido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_grado_repetidoItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox_grado_repetido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Género:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        buttonGroup1.add(jRadioButton_hombre);
        jRadioButton_hombre.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_hombre.setText("Masculino");
        jRadioButton_hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_hombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        buttonGroup1.add(jRadioButton_mujer);
        jRadioButton_mujer.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_mujer.setText("Femenino");
        jRadioButton_mujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_mujerActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_mujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel_genero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_genero.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_genero.setText("Grado / Curso:");
        getContentPane().add(jLabel_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jComboBox_grado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º grado (Varones)", "2º grado (Varones)", "3º grado (Varones)", "4º grado (Varones)", "5º grado (Varones)", "6º grado (Varones)", "7º grado (Varones)", "1º año (Varones)", "2º año (Varones)", "3º año (Varones)", "4º año (Varones)", "5º año (Varones)" }));
        getContentPane().add(jComboBox_grado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        jComboBox_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º grado (Mujeres)", "2º grado (Mujeres)", "3º grado (Mujeres)", "4º grado (Mujeres)", "5º grado (Mujeres)", "6º grado (Mujeres)", "7º grado (Mujeres)", "1º año (Mujeres)", "2º año (Mujeres)", "3º año (Mujeres)", "4º año (Mujeres)", "5º año (Mujeres)" }));
        getContentPane().add(jComboBox_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        InformaciónAlumnos1.informacionAlumnos4.setVisible(true);
        InformaciónAlumnos4.informacionAlumnos2.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        nombre_escuela = txt_nombre_escuela.getText().trim();
        numero_escuela = txt_numero_escuela.getText().trim();
        
        
        if(jRadioButton_repitio.isSelected()){
            repitio = "SI";
        } else {
            repitio = "NO";
        }
        
        if(jRadioButton_hombre.isSelected()){
            grado = jComboBox_grado1.getSelectedItem().toString();
            genero = "Masculino";
            
        } else {
            if(jRadioButton_mujer.isSelected()) {
                grado = jComboBox_grado.getSelectedItem().toString();
                genero = "Femenino";
            }
            else {
                grado = "1º grado (Varones)";
                genero = "No especificado";
            }
        }
        
        grado_repetido = jComboBox_grado_repetido.getSelectedItem().toString();
        
        //grado = jComboBox_grado.getSelectedItem().toString();
        
        informacionAlumnos3.setVisible(true);
        InformaciónAlumnos4.informacionAlumnos2.setVisible(false); //oculto pantalla al cerrarse
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jComboBox_grado_repetidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_grado_repetidoItemStateChanged
        /*
        jComboBox_grado_repetido.disable(); //deshabilitado por defecto
        
        if(jRadioButton_repitio.isSelected()){
            jComboBox_grado_repetido.enable();
        }*/
    }//GEN-LAST:event_jComboBox_grado_repetidoItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        
        jComboBox_grado_repetido.disable();
        
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jRadioButton_repitioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_repitioItemStateChanged
        
        jComboBox_grado_repetido.enable();
        
    }//GEN-LAST:event_jRadioButton_repitioItemStateChanged

    private void jRadioButton_hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_hombreActionPerformed
        jComboBox_grado.disable();
        jComboBox_grado1.enable();
    }//GEN-LAST:event_jRadioButton_hombreActionPerformed

    private void jRadioButton_mujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_mujerActionPerformed
        jComboBox_grado.enable();
        jComboBox_grado1.disable();
    }//GEN-LAST:event_jRadioButton_mujerActionPerformed

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
            java.util.logging.Logger.getLogger(InformaciónAlumnos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformaciónAlumnos2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_grado;
    private javax.swing.JComboBox<String> jComboBox_grado1;
    private javax.swing.JComboBox<String> jComboBox_grado_repetido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_genero;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton_hombre;
    private javax.swing.JRadioButton jRadioButton_mujer;
    private javax.swing.JRadioButton jRadioButton_repitio;
    private javax.swing.JTextField txt_nombre_escuela;
    private javax.swing.JTextField txt_numero_escuela;
    // End of variables declaration//GEN-END:variables
}
