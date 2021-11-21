package aras;


import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GestionarCursos extends javax.swing.JFrame {

    public static int user_update;
    Object[] cadena;
    
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    /**
     * Creates new form GestionarAlumnos
     */
    public GestionarCursos() {
        initComponents();
        // metodos para poder modificar la interfaz visual por codigo
        setSize(600,500); 
        setResizable(false);
        setTitle("Gestión de alumnos");
        setLocationRelativeTo(null);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select apellido,nombre, dni, grado, nivel from alumnos order by apellido");
            //selecciona esos valores de la tabla
            
            ResultSet rs = pst.executeQuery(); //ejecuto lo anterior
            jTable_gestionarAlumnos = new JTable(model); //declaramos la tabla y ponemos el model
            jScrollPane1.setViewportView(jTable_gestionarAlumnos); //la tabla esta contenida dentro de un jscrollpane

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Curso");
            model.addColumn("Nivel");

            while (rs.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila = new Object[5]; //son 4 columnas

                for (int i = 0; i < 5; i++) { //voy ingresando lo que vaya encontrando en la bd
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila); //añado al modelo toda la fila
            }
            cn.close(); //cierra la conexion

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla. " + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, ¡Contacte al administrador!");
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

        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
               //seleccionamos por defecto la columna 1 (nombre)
               int columna_point = 1;
               
               
               if(fila_point > -1){
                   user_update = (int) model.getValueAt(fila_point, 2); //nos devuelve el nombre
                   System.out.println(user_update);
                   AsignarCurso asignarCurso = new AsignarCurso(); //abro la proxima interfaz
                   asignarCurso.setVisible(true);
                   //dispose();
               }
               
            }
        });
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "select nivel from niveles order by nivel");
            
            //select nivel from niveles order by nivel
            //selecciona esos valores de la tabla
            
            ResultSet rs2 = pst2.executeQuery(); //ejecuto lo anterior
            
            
            jTable_niveles = new JTable(model2); //declaramos la tabla y ponemos el model
            jScrollPane2.setViewportView(jTable_niveles); //la tabla esta contenida dentro de un jscrollpane

            model2.addColumn("Niveles");
            model2.addColumn("aaaa");
            
            int j = 0;
            
            
            while (rs2.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila2 = new Object[2]; //son 4 columnas

                for (int i = 0; i < 1; i++) { //voy ingresando lo que vaya encontrando en la bd
                    fila2[i] = rs2.getObject(i + 1);                   
                    cadena[j] = rs2.getObject(i + 1);
                    fila2[1] = "-";
                }
                j++;
                model2.addRow(fila2); //añado al modelo toda la fila
            }
            cn2.close(); //cierra la conexion

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla. " + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, ¡Contacte al administrador!");
        }
        
        try{
            for(int j = 0; j<jTable_niveles.getRowCount(); j++){
            Connection cn3 = Conexion.conectar();
            PreparedStatement pst3 = cn3.prepareStatement(
                    "select count(nivel) from alumnos where nivel = '" + cadena[j] + "'");
            
            ResultSet rs3 = pst3.executeQuery();
           
        int k = 0;
        int cantFilas = 0;
        cantFilas = jTable_niveles.getRowCount();
        System.out.println(cantFilas);
        
        while (rs3.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila2 = new Object[2]; //son 4 columnas

                for (int i = 0; i < 1; i++) { //voy ingresando lo que vaya encontrando en la bd
                    //fila2[i] = rs2.getObject(i + 1);
                    String dato=String.valueOf(model2.getValueAt(k,0));
                    fila2[0] = dato;
                    fila2[1] = rs3.getObject(i + 1);
                }
                model2.addRow(fila2); //añado al modelo toda la fila
                k++;
            }
        cn3.close();
        }
        } catch (SQLException e) {
            System.err.println("Error en cargar niveles. " + e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_gestionarAlumnos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_nuevoCurso = new javax.swing.JTextField();
        jButton_agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_niveles = new javax.swing.JTable();
        jComboBox_nivel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Cursos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jTable_gestionarAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_gestionarAlumnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, 160));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione un alumnos para asignarle nivel:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        txt_nuevoCurso.setBackground(new java.awt.Color(51, 102, 255));
        txt_nuevoCurso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nuevoCurso.setForeground(new java.awt.Color(255, 255, 255));
        txt_nuevoCurso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nuevoCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nuevoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 210, 25));

        jButton_agregar.setText("Crear nivel");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jTable_niveles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_niveles);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 170, 100));

        jComboBox_nivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Sin Asignar" }));
        jComboBox_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_nivelActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del nuevo nivel:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        
        String nuevoNivel;
        nuevoNivel  = txt_nuevoCurso.getText().trim();
        
        if(!(nuevoNivel.equals(""))){
            try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("insert into niveles values (?)");
            
            pst2.setString(1, nuevoNivel);
            DefaultTableModel model3 = (DefaultTableModel) jTable_niveles.getModel();
            model3.addRow(new Object[]{nuevoNivel});
            JOptionPane.showMessageDialog(null, "Nuevo Nivel creado correctamente");
            txt_nuevoCurso.setText("");
                        
            pst2.executeUpdate();
            cn2.close();
                        
            } catch (SQLException e) {
                System.err.println("Error en Registrar nivel. " + e);
                JOptionPane.showMessageDialog(null, "¡ERROR al agregar nivel!, contacte al administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡No se especificó ningún nuevo curso!");
        }
        
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jComboBox_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_nivelActionPerformed
        actualizarTabla();
        
        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
               //seleccionamos por defecto la columna 1 (nombre)
               int columna_point = 1;
               
               
               if(fila_point > -1){
                   user_update = (int) model.getValueAt(fila_point, 2); //nos devuelve el nombre
                   System.out.println(user_update);
                   AsignarCurso asignarCurso = new AsignarCurso(); //abro la proxima interfaz
                   asignarCurso.setVisible(true);
                   //dispose();
               }
               
            }
        });
    }//GEN-LAST:event_jComboBox_nivelActionPerformed
    
    public void actualizarTabla(){
        
        String seleccion = jComboBox_nivel.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equals("Todos")) {
                query = "select apellido, nombre, dni, grado, nivel from alumnos order by apellido";
            } else {
                query = "select apellido, nombre, dni, grado, nivel from alumnos where nivel = '" + seleccion + "' order by apellido";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Curso");
            model.addColumn("Nivel");

            while(rs.next()){
                Object [] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de alumnos. " + e);
        }
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
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JComboBox<String> jComboBox_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_gestionarAlumnos;
    private javax.swing.JTable jTable_niveles;
    private javax.swing.JTextField txt_nuevoCurso;
    // End of variables declaration//GEN-END:variables
}
