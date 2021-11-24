package aras;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mjgod
 */
public class InformaciónAlumnos4 extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    //String user_update = "";
    int user_update;
    public static int fila_point;
    int cantfilas = 0, filasAgregadas = 0, ban = 0;
    //public static InformaciónAlumnos2 informacionAlumnos2 = new InformaciónAlumnos2();
    public static InformaciónAlumnos2 informacionAlumnos2;
    public InformaciónAlumnos4() {
        initComponents();
        user_update = GestionarAlumnos.user_update;
        String nombre_alumno = InformaciónAlumnos1.nombre;
        int dni_alumno = InformaciónAlumnos1.dni_numerico;
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Gestión de alumnos");
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        System.out.println("Se creo el jframe 4");
        System.out.println(user_update);
        informacionAlumnos2 = new InformaciónAlumnos2();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_familiar, parentesco, edad, ocupacion from familiares where dni_familiar = '" + user_update + "'");
            //selecciona esos valores de la tabla
            
            ResultSet rs = pst.executeQuery(); //ejecuto lo anterior
            jTable1 = new JTable(model); //declaramos la tabla y ponemos el model
            jScrollPane1.setViewportView(jTable1); //la tabla esta contenida dentro de un jscrollpane

            //agrego los titulos de las columnas
            model.addColumn("Nombre");
            model.addColumn("Parentesco");
            model.addColumn("Edad");
            model.addColumn("Ocupación");

            while (rs.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila = new Object[4]; //son 4 columnas

                for (int i = 0; i < 4; i++) { //voy ingresando lo que vaya encontrando en la bd
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila); //añado al modelo toda la fila
                cantfilas++;
            }
            cn.close(); //cierra la conexion
            
           
        } catch (SQLException e) {
            System.err.println("Error al llenar tabla. " + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, ¡Contacte al administrador!");
        }
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               fila_point = jTable1.rowAtPoint(e.getPoint());
               
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton_agregar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grupo familiar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Apellido y Nombre", "Parentesco", "Edad", "Ocupación"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 550, 220));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Siguiente >");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 140, 50));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("< Anterior");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 140, 50));

        jButton_agregar.setBackground(new java.awt.Color(51, 102, 255));
        jButton_agregar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregar.setText("Agregar");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(51, 102, 255));
        jButton_eliminar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setText("Limpiar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        for(int i = 0; i < jTable1.getRowCount(); i++){
            if("".equals(jTable1.getValueAt(i, 2))) {
                jTable1.setValueAt("0",i, 2);
            }
            if("".equals((String) jTable1.getValueAt(i, 0))) {
                jTable1.setValueAt("-",i, 0);
            }
            if("".equals((String) jTable1.getValueAt(i, 1))) {
                jTable1.setValueAt("-",i, 1);
            }
            if("".equals((String) jTable1.getValueAt(i, 3))) {
                jTable1.setValueAt("-",i, 3);
            }
        }
        
        GestionarAlumnos.informacion_alumnos1.setVisible(true);
        InformaciónAlumnos1.informacionAlumnos4.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        for(int i = 0; i < jTable1.getRowCount(); i++){
            if("".equals(jTable1.getValueAt(i, 2))) {
                jTable1.setValueAt("0",i, 2);
            }
            if("".equals((String) jTable1.getValueAt(i, 0))) {
                jTable1.setValueAt("-",i, 0);
            }
            if("".equals((String) jTable1.getValueAt(i, 1))) {
                jTable1.setValueAt("-",i, 1);
            }
            if("".equals((String) jTable1.getValueAt(i, 3))) {
                jTable1.setValueAt("-",i, 3);
            }
        }
        informacionAlumnos2.setVisible(true);
        InformaciónAlumnos1.informacionAlumnos4.setVisible(false); //oculto pantalla al cerrarse
    }//GEN-LAST:event_jButton1ActionPerformed

    public void actualizarFamiliares(){
        
        String nombre_alumno = InformaciónAlumnos1.nombre;
        String apellido_alumno = InformaciónAlumnos1.apellido;
        int dni_alumno = InformaciónAlumnos1.dni_numerico;
        user_update = GestionarAlumnos.user_update;

        System.out.println(cantfilas);
        if(ban == 0) {
            if(jTable1.getRowCount()>0){
                for(int i = 0; i < jTable1.getRowCount(); i++){
                    if(i < cantfilas){
                        String dato = String.valueOf(model.getValueAt(i,0));
                        try {

    //no anda porque no estoy siendo especifico a quien quiero modificar, habria q agregar una id, toda la familia va a tener el mismo id familiar
                            //el nombre debe permanecer igual para que funcione.
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("update familiares set id=?, apellido=?, dni_familiar=?, nombre_familiar=?,"
                                    + "parentesco=?,edad=?,ocupacion=? where dni_familiar = '" + user_update + "' and nombre_familiar = '" + dato + "'");
                            System.out.println(nombre_alumno + dni_alumno);
                            pst.setString(1, nombre_alumno);
                            pst.setString(2, apellido_alumno); //--
                            pst.setInt(3, dni_alumno);
                            pst.setString(4, (String) jTable1.getValueAt(i, 0));
                            pst.setString(5, (String) jTable1.getValueAt(i, 1));
                            pst.setObject(6, jTable1.getValueAt(i, 2));
                            //pst.setInt(6, (int) jTable1.getValueAt(i, 2));
                            pst.setString(7, (String) jTable1.getValueAt(i, 3));
                            pst.executeUpdate();
                            cn.close();
                            this.dispose();
                        }
                        catch (SQLException e) {
                            System.err.println("Error en Registrar familiares. " + e);
                            JOptionPane.showMessageDialog(null, "¡ERROR al registrar familiares!, contacte al administrador.");
                        }
                    } else {
                        if(!("-".equals((String) jTable1.getValueAt(i, 0)))) { //Si de los familiares nuevos, hay uno que es basura, no lo subo a bd
                            try {

                                Connection cn = Conexion.conectar();
                                PreparedStatement pst = cn.prepareStatement("insert into familiares values (?,?,?,?,?,?,?)");
                                pst.setString(1, nombre_alumno);
                                pst.setString(2, apellido_alumno); //--
                                pst.setInt(3, dni_alumno);
                                pst.setString(4, (String) jTable1.getValueAt(i, 0));
                                pst.setString(5, (String) jTable1.getValueAt(i, 1));
                                pst.setString(6, (String) jTable1.getValueAt(i, 2));
                                pst.setString(7, (String) jTable1.getValueAt(i, 3));
                                pst.executeUpdate();
                                cn.close();
                                this.dispose();
                            }
                            catch (SQLException e) {
                                System.err.println("Error en Registrar familiares. " + e);
                                JOptionPane.showMessageDialog(null, "¡ERROR al registrar familiares!, contacte al administrador.");
                            }
                        }
                    } 

                }


            } else {
                JOptionPane.showMessageDialog(null, "La tabla esta vacía!!!");
            }
        } else {
            
            //Si se limpio la tabla se ejecuta lo siguiente
            for(int i = 0; i < jTable1.getRowCount(); i++) {
                if(!("-".equals((String) jTable1.getValueAt(i, 0)))) {
                try {

                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("insert into familiares values (?,?,?,?,?,?,?)");
                            pst.setString(1, nombre_alumno);
                            pst.setString(2, apellido_alumno); //--
                            pst.setInt(3, dni_alumno);
                            pst.setString(4, (String) jTable1.getValueAt(i, 0));
                            pst.setString(5, (String) jTable1.getValueAt(i, 1));
                            pst.setString(6, (String) jTable1.getValueAt(i, 2));
                            pst.setString(7, (String) jTable1.getValueAt(i, 3));
                            pst.executeUpdate();
                            cn.close();
                            this.dispose();
                        }
                        catch (SQLException e) {
                            System.err.println("Error en Registrar familiares. " + e);
                            JOptionPane.showMessageDialog(null, "¡ERROR al registrar familiares!, contacte al administrador.");
                        }
                }
            }
            
        }
    }
    
    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"","","",""});
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        //PARA ELIMINAR UN FAMILIAR, SE ELIMINARA TODA LA TABLA
        
        for(int i = 0; i < jTable1.getRowCount(); i++){
            String dato = String.valueOf(model.getValueAt(i,0));
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst;
                pst = cn.prepareStatement(
                        "delete from familiares where dni_familiar = '" + user_update + "' and nombre_familiar = '" + dato + "'");
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.err.println("Error al eliminar familiar. " + ex);
            }
        }
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        ban = 1;
        //ObtenerDatosTabla();
        //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //jTable1.setValueAt("0",fila_point, 2);
        //jTable1.setValueAt("-",fila_point, 0);
        //jTable1.setValueAt("-",fila_point, 1);
        //jTable1.setValueAt("-",fila_point, 3);
        //model.removeRow(fila_point);
        //ObtenerDatosTabla();
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    public void ObtenerDatosTabla() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               fila_point = jTable1.rowAtPoint(e.getPoint());
               
            }
        });
    }
    
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
            java.util.logging.Logger.getLogger(InformaciónAlumnos4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformaciónAlumnos4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
