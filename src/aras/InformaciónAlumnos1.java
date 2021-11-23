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
public class InformaciónAlumnos1 extends javax.swing.JFrame {
    
    public static String nombre = "", apellido, lugar, fecha, localidad, domicilio, nombre_madre, nombre_padre, telefono, telefono2, dni, dni_madre, dni_padre, fechaIns;
    public static InformaciónAlumnos4 informacionAlumnos4;
    int ID;
    //String user_update = "";
    int user_update;
    public static int dni_numerico = 0;
    
    
    public InformaciónAlumnos1() {
        initComponents();
        user_update = GestionarAlumnos.user_update;
        
        setResizable(false);
        setTitle("Gestión de alumnos");
        setLocationRelativeTo(null);
        setSize(700,500);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        txt_dni.setEnabled(false); //bloqueo el dni para que no se pueda modificar
        txt_nombre.setEditable(false);
        txt_apellido.setEditable(false);
        
        System.out.println("Se creo jframe 1");
        //Lo creo apenas se lanza
        informacionAlumnos4 = new InformaciónAlumnos4();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select * from alumnos where dni = '" + user_update + "'"); //selecciono los datos del alumno elegido
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                //Realizo el vaciado de datos en los jtextfield.
                txt_nombre.setText(rs.getString("nombre"));
                txt_apellido.setText(rs.getString("apellido"));
                txt_nombre_padre.setText(rs.getString("nombre_padre"));
                txt_nombre_madre.setText(rs.getString("nombre_madre"));
                txt_lugar_nacimiento.setText(rs.getString("lugar_nacimiento"));
                txt_lugar.setText(rs.getString("nacimiento"));
                txt_domicilio.setText(rs.getString("domicilio"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_telefono2.setText(rs.getString("telefono2"));
                txt_localidad.setText(rs.getString("localidad"));
                txt_dni.setText(rs.getString("dni"));
                txt_dni_padre.setText(rs.getString("dni_padre"));
                txt_dni_madre.setText(rs.getString("dni_madre"));
                txt_fechains.setText(rs.getString("fecha"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar usuario. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
        
        //CerrarVentana();
        
    }
    
    //Metodo para cerrar este Jframe desde otros.
    public void CerrarVentana(){
        //if(InformaciónAlumnos3.informacionAlumnos3.ban == 1){
            this.dispose();
        //}
    }
    
    /*
    public void CerrarVentana(){
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
        //InformaciónAlumnos1.informacionAlumnos4.setVisible(true);
        informacionAlumnos4.dispose();
        //InformaciónAlumnos4.informacionAlumnos2.setVisible(true);
        InformaciónAlumnos4.informacionAlumnos2.dispose();
        InformaciónAlumnos2.informacionAlumnos3.dispose();
        //System.exit(0);
        }
    });
    }*/
    
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
        jLabel5 = new javax.swing.JLabel();
        txt_domicilio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_localidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre_madre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_dni_madre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre_padre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_dni_padre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_lugar_nacimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_telefono2 = new javax.swing.JTextField();
        txt_fechains = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información del Alumno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 210, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txt_dni.setBackground(new java.awt.Color(51, 102, 255));
        txt_dni.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_dni.setForeground(new java.awt.Color(255, 255, 255));
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        txt_lugar.setBackground(new java.awt.Color(51, 102, 255));
        txt_lugar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_lugar.setForeground(new java.awt.Color(255, 255, 255));
        txt_lugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lugar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Domicilio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        txt_domicilio.setBackground(new java.awt.Color(51, 102, 255));
        txt_domicilio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_domicilio.setForeground(new java.awt.Color(255, 255, 255));
        txt_domicilio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_domicilio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Localidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        txt_localidad.setBackground(new java.awt.Color(51, 102, 255));
        txt_localidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_localidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_localidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_localidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_localidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre de la madre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        txt_nombre_madre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre_madre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre_madre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre_madre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre_madre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre_madre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 210, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        txt_dni_madre.setBackground(new java.awt.Color(51, 102, 255));
        txt_dni_madre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_dni_madre.setForeground(new java.awt.Color(255, 255, 255));
        txt_dni_madre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni_madre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_dni_madre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 210, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre del padre:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        txt_nombre_padre.setBackground(new java.awt.Color(51, 102, 255));
        txt_nombre_padre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre_padre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre_padre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre_padre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre_padre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 210, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DNI:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        txt_dni_padre.setBackground(new java.awt.Color(51, 102, 255));
        txt_dni_padre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_dni_padre.setForeground(new java.awt.Color(255, 255, 255));
        txt_dni_padre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni_padre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_dni_padre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 210, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono de contacto:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(51, 102, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 210, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 140, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Apellido:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(51, 102, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 210, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lugar de nacimiento:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txt_lugar_nacimiento.setBackground(new java.awt.Color(51, 102, 255));
        txt_lugar_nacimiento.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_lugar_nacimiento.setForeground(new java.awt.Color(255, 255, 255));
        txt_lugar_nacimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lugar_nacimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_lugar_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Otro teléfono:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        txt_telefono2.setBackground(new java.awt.Color(51, 102, 255));
        txt_telefono2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono2.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 210, 25));

        txt_fechains.setBackground(new java.awt.Color(51, 102, 255));
        txt_fechains.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fechains.setForeground(new java.awt.Color(255, 255, 255));
        txt_fechains.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fechains.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_fechains, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 210, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha de inscripción:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fechaIns = txt_fechains.getText().trim();
        nombre = txt_nombre.getText().trim();
        apellido = txt_apellido.getText().trim();
        nombre_madre = txt_nombre_madre.getText().trim();
        nombre_padre = txt_nombre_padre.getText().trim();
        fecha = txt_lugar.getText().trim();
        lugar = txt_lugar_nacimiento.getText().trim();
        domicilio = txt_domicilio.getText().trim();
        localidad = txt_localidad.getText().trim();
        telefono = txt_telefono.getText().trim();
        telefono2 = txt_telefono2.getText().trim();
        dni = txt_dni.getText().trim();
        dni_padre = txt_dni_padre.getText().trim();
        dni_madre = txt_dni_madre.getText().trim();
        
        dni_numerico = Integer.parseInt(dni);
        
        informacionAlumnos4.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(InformaciónAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformaciónAlumnos1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_dni_madre;
    private javax.swing.JTextField txt_dni_padre;
    private javax.swing.JTextField txt_domicilio;
    private javax.swing.JTextField txt_fechains;
    private javax.swing.JTextField txt_localidad;
    private javax.swing.JTextField txt_lugar;
    private javax.swing.JTextField txt_lugar_nacimiento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_madre;
    private javax.swing.JTextField txt_nombre_padre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_telefono2;
    // End of variables declaration//GEN-END:variables
}
