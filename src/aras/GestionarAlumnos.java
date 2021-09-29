package aras;


import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class GestionarAlumnos extends javax.swing.JFrame {

    public static int user_update;
    //public static InformaciónAlumnos1 informacion_alumnos1 = new InformaciónAlumnos1();
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form GestionarAlumnos
     */
    public GestionarAlumnos() {
        initComponents();
        // metodos para poder modificar la interfaz visual por codigo
        setSize(650,430); 
        setResizable(false);
        setTitle("Sistema de Registro");
        setLocationRelativeTo(null);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id, nombre, dni, nombre_escuela, grado from alumnos");
            //selecciona esos valores de la tabla
            
            ResultSet rs = pst.executeQuery(); //ejecuto lo anterior
            jTable_gestionarAlumnos = new JTable(model); //declaramos la tabla y ponemos el model
            jScrollPane1.setViewportView(jTable_gestionarAlumnos); //la tabla esta contenida dentro de un jscrollpane

            model.addColumn(" "); //agrego los titulos de las columnas
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");

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
                   InformaciónAlumnos1 informacion_alumnos1 = new InformaciónAlumnos1(); //abro la proxima interfaz
                   informacion_alumnos1.setVisible(true);
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
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Alumnos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 700, 290));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_gestionarAlumnos;
    // End of variables declaration//GEN-END:variables
}
