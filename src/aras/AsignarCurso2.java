package aras;

import static aras.Cursos.user_update;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import clases.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mjgod
 */
public class AsignarCurso2 extends javax.swing.JFrame {
    
    int user_update;
    
    
    public AsignarCurso2() {
        initComponents();
        user_update = Cursos.user_update;
        
        setResizable(false);
        setTitle("Gestión de cursos");
        setLocationRelativeTo(null);
        setSize(550,320);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        txt_nombre.setEditable(false);
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
            "select nivel from niveles order by nivel");
            ResultSet rs2 = pst2.executeQuery();
            
            while(rs2.next()){
                jComboBox_nivel.addItem(rs2.getString("nivel"));
            }
            cn2.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar niveles. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
        
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e){
                //le indicamos la fila que selecciono el usuario
                int fila_point = jTable1.rowAtPoint(e.getPoint());
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                if(fila_point > -1){
                    String dato = (String) model.getValueAt(fila_point, 0);
                    System.out.println(dato);
                    
                    txt_nombre.setText(dato);

                }

            }
        });
        
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
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_nivel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignar nivel por curso");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nivel asignado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 25));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 140, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccione un curso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jComboBox_nivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Asignar" }));
        getContentPane().add(jComboBox_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del curso:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1º grado (Varones)"},
                {"2º grado (Varones)"},
                {"3º grado (Varones)"},
                {"4º grado (Varones)"},
                {"5º grado (Varones)"},
                {"6º grado (Varones)"},
                {"7º grado (Varones)"},
                {"1º año (Varones)"},
                {"2º año (Varones)"},
                {"3º año (Varones)"},
                {"4º año (Varones)"},
                {"5º año (Varones)"},
                {"1º grado (Mujeres)"},
                {"2º grado (Mujeres)"},
                {"3º grado (Mujeres)"},
                {"4º grado (Mujeres)"},
                {"5º grado (Mujeres)"},
                {"6º grado (Mujeres)"},
                {"7º grado (Mujeres)"},
                {"1º año (Mujeres)"},
                {"2º año (Mujeres)"},
                {"3º año (Mujeres)"},
                {"4º año (Mujeres)"},
                {"5º año (Mujeres)"}
            },
            new String [] {
                "Curso/Año"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String seleccion = jComboBox_nivel.getSelectedItem().toString();
        String curso = txt_nombre.getText();
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("update alumnos set nivel=?"
                    + " where grado ='" + curso + "'");
            
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
            java.util.logging.Logger.getLogger(AsignarCurso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarCurso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AsignarCurso2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
