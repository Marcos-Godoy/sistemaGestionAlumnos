package aras;


import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
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
public class ListarAlumnos extends javax.swing.JFrame {

    public static String user_update = "";
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form GestionarAlumnos
     */
    public ListarAlumnos() {
        initComponents();
        // metodos para poder modificar la interfaz visual por codigo
        setSize(700,500); 
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
                    "select id, nombre, apellido, dni, nombre_escuela, grado from alumnos order by apellido");
            //selecciona esos valores de la tabla
            
            ResultSet rs = pst.executeQuery(); //ejecuto lo anterior
            jTable_gestionarAlumnos = new JTable(model); //declaramos la tabla y ponemos el model
            jScrollPane1.setViewportView(jTable_gestionarAlumnos); //la tabla esta contenida dentro de un jscrollpane

            model.addColumn(" "); //agrego los titulos de las columnas
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");

            while (rs.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila = new Object[6]; //son 6 columnas

                for (int i = 0; i < 6; i++) { //voy ingresando lo que vaya encontrando en la bd
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila); //añado al modelo toda la fila
            }
            cn.close(); //cierra la conexion

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla. " + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, ¡Contacte al administrador!");
        }

        ObtenerDatosTabla();
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

        Mostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmb_filtro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_gestionarAlumnos = new javax.swing.JTable();
        Imprimir = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Mostrar.setBackground(new java.awt.Color(153, 153, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 210, 35));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listar Alumnos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        cmb_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1º grado", "2º grado", "3º grado", "4º grado", "5º grado", "6º grado", "7º grado", "1º año", "2º año", "3º año", "4º año", "5º año" }));
        getContentPane().add(cmb_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

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

        Imprimir.setBackground(new java.awt.Color(153, 153, 255));
        Imprimir.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Imprimir.setForeground(new java.awt.Color(255, 255, 255));
        Imprimir.setText("Imprimir");
        Imprimir.setBorder(null);
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String seleccion = cmb_filtro.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equals("Todos")) {
                query = "select id, nombre, apellido, dni, nombre_escuela, grado from alumnos order by apellido";
            } else {
                query = "select id, nombre, apellido, dni, nombre_escuela, grado from alumnos where grado = '" + seleccion + "' order by apellido";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");

            while(rs.next()){
                Object [] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de alumnos. " + e);
        }
ObtenerDatosTabla();
    }//GEN-LAST:event_MostrarActionPerformed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        
        String seleccion = cmb_filtro.getSelectedItem().toString();
        String query = "";
        
        Document documento = new Document(); //creo objeto de la clase document
        try {
            String ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListadoAsistencia.pdf")); //complementamos la ruta
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg"); //agrego el header
            header.scaleToFit(300, 900); //tamaño del header
            header.setAlignment(Chunk.ALIGN_CENTER); //posicion centrada del header
            
            Paragraph parrafo = new Paragraph(); //creo el parrafo del pdf
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Listado de asistencia\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)); //le doy la fuente
            
            documento.open();
            documento.add(header); //le agrego los elementos al documento
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(26); //agrego las columnas
            
            // Set Table Total Width
            //tabla.setTotalWidth(50);
            
            // CREO UN ARREGLO QUE CONTIENE LAS MEDIDAS DE CADA UNA DE LAS COLUMNAS
// EN MI CASO SON 4, (TB PUEDES PASAR EL ARREGLO DIRECTAMENTE)
            float var = 0.15f;
            float[] medidaCeldas = {1.0f, 1.0f, var, var, var, var, var, var, var, var, var, var,
                var, var, var, var, var, var, var, var, var, var, var, var, var, var};
            /*
            medidaCeldas[0] = 1.0f;
            for (int i=1; i < 25; i++){
                medidaCeldas[i] = var;      
            }*/

// ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
            tabla.setWidths(medidaCeldas);
            
            tabla.addCell("Apellido");
            tabla.addCell("Nombre");
            
            
            for(int i = 0; i < 24; i++){
                tabla.addCell("");
            }
            
            if (seleccion.equals("Todos")) {
                    query = "select apellido, nombre from alumnos order by apellido";
            } else {
                query = "select apellido, nombre from alumnos where grado = '" + seleccion + "' order by apellido";
            }
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(query);

                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    do {                        
                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        
                        for(int i = 0; i < 24; i++){
                            tabla.addCell("");
                        }
                        
                    } while (rs.next());
                    documento.add(tabla);
                }
                
            } catch (SQLException e) {
                System.out.println("Error al generar lista de alumnos. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de alumnos creada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al generar PDF. " + e);
        }
        
    }//GEN-LAST:event_ImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(ListarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> cmb_filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_gestionarAlumnos;
    // End of variables declaration//GEN-END:variables


    public void ObtenerDatosTabla() {
        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
                int columna_point = 0;
/*
                if (fila_point > -1) {
                    IDequipo_update = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico info = new InformacionEquipoTecnico();
                    info.setVisible(true);

                }*/
            }

        });
    }
}


