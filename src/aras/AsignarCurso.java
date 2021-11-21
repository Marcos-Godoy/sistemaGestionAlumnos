package aras;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import clases.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mjgod
 */
public class AsignarCurso extends javax.swing.JFrame {
    
    int user_update;
    
    
    public AsignarCurso() {
        initComponents();
        user_update = Cursos.user_update;
        
        setResizable(false);
        setTitle("Gestión de alumnos");
        setLocationRelativeTo(null);
        setSize(550,320);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        txt_dni.setEnabled(false); //bloqueo el dni para que no se pueda modificar
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombre, apellido, grado, dni from alumnos where dni = '" + user_update + "'"); //selecciono los datos del alumno elegido
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                //Realizo el vaciado de datos en los jtextfield.
                txt_nombre.setText(rs.getString("nombre"));
                txt_apellido.setText(rs.getString("apellido"));
                txt_lugar.setText(rs.getString("grado"));
                txt_dni.setText(rs.getString("dni"));

            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar alumno. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
        
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
            "select nivel from niveles");
            ResultSet rs2 = pst2.executeQuery();
            
            while(rs2.next()){
                jComboBox_nivel.addItem(rs2.getString("nivel"));
            }
            cn2.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar niveles. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nivel from alumnos where dni = '" + user_update + "'"); //selecciono los datos del usuario elegido
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                jComboBox_nivel.setSelectedItem(rs.getString("nivel"));    
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar nivel. " + e);
        }
        
        
    }
    
    
    //Reemplazar el icono de java por default
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/cuatroVientos.jpg"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_lugar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_nivel = new javax.swing.JComboBox<>();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información del Alumno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nivel asignado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txt_dni.setBackground(new java.awt.Color(51, 102, 255));
        txt_dni.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_dni.setForeground(new java.awt.Color(255, 255, 255));
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grado/Año:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txt_lugar.setBackground(new java.awt.Color(51, 102, 255));
        txt_lugar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_lugar.setForeground(new java.awt.Color(255, 255, 255));
        txt_lugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lugar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, -1));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Asignar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 140, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Apellido:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(51, 102, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jComboBox_nivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Asignar" }));
        getContentPane().add(jComboBox_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 100, 30));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String seleccion = jComboBox_nivel.getSelectedItem().toString();
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("update alumnos set nivel=?"
                    + " where dni ='" + user_update + "'");
            
            pst2.setString(1, seleccion);
            JOptionPane.showMessageDialog(null, "Nivel asigando correctamente.");
                        
            pst2.executeUpdate();
            cn2.close();
            Cursos cursos = new Cursos();
            cursos.setVisible(true);
            dispose();
                        
            } catch (SQLException e) {
                System.err.println("Error en Asigar nivel. " + e);
                JOptionPane.showMessageDialog(null, "¡ERROR al asignar nivel!, contacte al administrador.");
            }
        //GestionarCursos.actualizarTabla();
        
        
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
            java.util.logging.Logger.getLogger(AsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_lugar;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
