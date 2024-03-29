package aras;


import static aras.GestionarAlumnos.user_update;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.*;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WriteException;


/**
 *
 * @author mjgod
 */
public class ListarAlumnos extends javax.swing.JFrame {

    public static String user_update = "";
    public static int name;
    DefaultTableModel model = new DefaultTableModel();
    
    public ListarAlumnos() {
        initComponents();
        // metodos para poder modificar la interfaz visual por codigo

        setResizable(false);
        setTitle("Listado de alumnos");
        setLocationRelativeTo(null);
        setSize(710,510);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //establece la imagen como fondo de la aplicacion
        ImageIcon wallpaper = new ImageIcon("src/images/fondo5.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select apellido,nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido");
            //selecciona esos valores de la tabla
            
            ResultSet rs = pst.executeQuery(); //ejecuto lo anterior
            jTable_gestionarAlumnos = new JTable(model); //declaramos la tabla y ponemos el model
            jScrollPane1.setViewportView(jTable_gestionarAlumnos); //la tabla esta contenida dentro de un jscrollpane

            //agrego los titulos de las columnas
            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");
            model.addColumn("Nivel");

            while (rs.next()) { //para ver si encontro resultados o coincidencias
                Object[] fila = new Object[6]; //son 5 columnas

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
        
        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
               //seleccionamos por defecto la columna 1 (nombre)
               int columna_point = 1;
               
               
               if(fila_point > -1){
                   name = (int) model.getValueAt(fila_point, 2); //nos devuelve el nombre
                   user_update = (String) model.getValueAt(fila_point, 0);
                   System.out.println(name);
                   System.out.println(user_update);
               }
               
            }
        });
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
            "select nivel from niveles order by nivel");
            ResultSet rs2 = pst2.executeQuery();
            
            while(rs2.next()){
                cmb_filtroNivel.addItem(rs2.getString("nivel"));
            }
            cn2.close();
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

        Mostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmb_filtro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_gestionarAlumnos = new javax.swing.JTable();
        Imprimir = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton_estadistica = new javax.swing.JButton();
        cmb_filtroNivel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Mostrar.setBackground(new java.awt.Color(51, 102, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Actualizar Tabla");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 210, 35));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listar Alumnos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        cmb_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1º grado (Varones)", "2º grado (Varones)", "3º grado (Varones)", "4º grado (Varones)", "5º grado (Varones)", "6º grado (Varones)", "7º grado (Varones)", "1º año (Varones)", "2º año (Varones)", "3º año (Varones)", "4º año (Varones)", "5º año (Varones)", "1º grado (Mujeres)", "2º grado (Mujeres)", "3º grado (Mujeres)", "4º grado (Mujeres)", "5º grado (Mujeres)", "6º grado (Mujeres)", "7º grado (Mujeres)", "1º año (Mujeres)", "2º año (Mujeres)", "3º año (Mujeres)", "4º año (Mujeres)", "5º año (Mujeres)" }));
        cmb_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filtroActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

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

        Imprimir.setBackground(new java.awt.Color(51, 102, 255));
        Imprimir.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Imprimir.setForeground(new java.awt.Color(255, 255, 255));
        Imprimir.setText("Imprimir");
        Imprimir.setBorder(null);
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 210, 35));

        jButton_eliminar.setBackground(new java.awt.Color(51, 102, 255));
        jButton_eliminar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 120, 30));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Guardar Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 120, 30));

        jButton_estadistica.setBackground(new java.awt.Color(51, 102, 255));
        jButton_estadistica.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jButton_estadistica.setForeground(new java.awt.Color(255, 255, 255));
        jButton_estadistica.setText("Estadísticas");
        jButton_estadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_estadisticaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_estadistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 120, 30));

        cmb_filtroNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Sin Asignar" }));
        cmb_filtroNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filtroNivelActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_filtroNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nivel");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Curso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String seleccion = cmb_filtro.getSelectedItem().toString();
        String seleccion2 = cmb_filtroNivel.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equals("Todos") && seleccion2.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido";
            } else {
                if(seleccion.equals("Todos")) {
                    query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where nivel = '" + seleccion2 + "' order by apellido";
                } else {
                    if(seleccion2.equals("Todos")){
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' order by apellido";
                    } else {
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' and nivel = '" + seleccion2 + "' order by apellido";
                    }
                }
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");
            model.addColumn("Nivel");

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
        
        
      
        int seleccion1 = JOptionPane.showOptionDialog( null,"Seleccione una opcion",
          "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
           JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
          new Object[] { "Por curso", "Por nivel", "Cancelar"},"Por curso");

         if (seleccion1 != -1){
                   System.out.println("seleccionada opcion " + (seleccion1 + 1));
         }
         
        if(seleccion1 == 0) {
            String seleccion = cmb_filtro.getSelectedItem().toString();
            String query = "";

            Document documento = new Document(); //creo objeto de la clase document
            try {
                String ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Sistema de Registro/Listados de Asistencia/Listado " + seleccion + ".pdf")); //complementamos la ruta

                com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg"); //agrego el header
                header.scaleToFit(300, 900); //tamaño del header
                header.setAlignment(Chunk.ALIGN_CENTER); //posicion centrada del header

                Font f=new Font(FontFactory.getFont(FontFactory.TIMES_ROMAN,14.0f,Font.BOLDITALIC,BaseColor.BLACK));
                Paragraph parrafo = new Paragraph("\nLista de Alumnos: " + seleccion,f); //creo el parrafo del pdf
                parrafo.add("\n\n");
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);

                documento.open();
                documento.add(header); //le agrego los elementos al documento
                documento.add(parrafo);

                PdfPTable tabla = new PdfPTable(26); //agrego las columnas
                int contador = 1;
                // Set Table Total Width
                //tabla.setTotalWidth(50);

                // CREO UN ARREGLO QUE CONTIENE LAS MEDIDAS DE CADA UNA DE LAS COLUMNAS
    // EN MI CASO SON 4, (TB PUEDES PASAR EL ARREGLO DIRECTAMENTE)
                float var = 0.25f;
                float[] medidaCeldas = {0.35f, 2.0f, var, var, var, var, var, var, var, var, var, var,
                    var, var, var, var, var, var, var, var, var, var, var, var, var, var};
                /*
                medidaCeldas[0] = 1.0f;
                for (int i=1; i < 25; i++){
                    medidaCeldas[i] = var;      
                }*/

    // ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
                tabla.setWidthPercentage(100);
                tabla.setTotalWidth(1000);
                tabla.setWidths(medidaCeldas);

                tabla.addCell(" ");
                tabla.addCell("Apellido y Nombre");
                //tabla.addCell("Nombre");


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
                            String cont;
                            cont = String.valueOf(contador);
                            contador ++;
                            tabla.addCell(cont);
                            tabla.addCell(rs.getString(1) + ", " + rs.getString(2));
                            //tabla.addCell(rs.getString(2));

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
        } else {
            
            if(seleccion1 == 1){
                
                String seleccion = cmb_filtroNivel.getSelectedItem().toString();
                String query = "";

                Document documento = new Document(); //creo objeto de la clase document
                try {
                    String ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Sistema de Registro/Listados de Asistencia/Listado " + seleccion + ".pdf")); //complementamos la ruta

                    com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg"); //agrego el header
                    header.scaleToFit(300, 900); //tamaño del header
                    header.setAlignment(Chunk.ALIGN_CENTER); //posicion centrada del header

                    Font f=new Font(FontFactory.getFont(FontFactory.TIMES_ROMAN,14.0f,Font.BOLDITALIC,BaseColor.BLACK));
                    Paragraph parrafo = new Paragraph("\nLista de Alumnos: " + seleccion,f); //creo el parrafo del pdf
                    parrafo.add("\n\n");
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);

                    documento.open();
                    documento.add(header); //le agrego los elementos al documento
                    documento.add(parrafo);

                    PdfPTable tabla = new PdfPTable(26); //agrego las columnas
                    int contador = 1;
                    
                    float var = 0.25f;
                    float[] medidaCeldas = {0.35f, 2.0f, var, var, var, var, var, var, var, var, var, var,
                        var, var, var, var, var, var, var, var, var, var, var, var, var, var};
                    
                    tabla.setWidthPercentage(100);
                    tabla.setTotalWidth(1000);
                    tabla.setWidths(medidaCeldas);

                    tabla.addCell(" ");
                    tabla.addCell("Apellido y Nombre");
                    


                    for(int i = 0; i < 24; i++){
                        tabla.addCell("");
                    }

                    if (seleccion.equals("Todos")) {
                            query = "select apellido, nombre from alumnos order by apellido";
                    } else {
                        query = "select apellido, nombre from alumnos where nivel = '" + seleccion + "' order by apellido";
                    }

                    try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement(query);

                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            do {
                                String cont;
                                cont = String.valueOf(contador);
                                contador ++;
                                tabla.addCell(cont);
                                tabla.addCell(rs.getString(1) + ", " + rs.getString(2));

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
                
            } else {
                System.out.println("Cancelado");
            }
            
        }
        
    }//GEN-LAST:event_ImprimirActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        /*
        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
               //seleccionamos por defecto la columna 1 (nombre)
               int columna_point = 1;
               
               
               if(fila_point > -1){
                   name = (int) model.getValueAt(fila_point, 2); //nos devuelve el dni
                   user_update = (String) model.getValueAt(fila_point, 1);
                   System.out.println(name);
                   System.out.println(user_update);
                   
               }
               
            }
        });
        */
        int dni, fila;
        String apellido;
        dni = name;
        //fila = fila_point;
        apellido = user_update;
        //int fila = fila_point;
        int input = JOptionPane.showConfirmDialog(null, "¿Seguro que querés eliminar a este alumno?");
        // 0=yes, 1=no, 2=cancel
        System.out.println(input);
        
        if(input == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst;
                pst = cn.prepareStatement(
                        "delete from alumnos where dni = '" + dni + "' and apellido = '" + apellido + "'");
                //selecciona esos valores de la tabla
                pst.executeUpdate(); //ejecuto lo anterior
                //model.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente.");
                //model.removeRow(fila+1);
            } catch (SQLException ex) {
                System.err.println("Error al eliminar alumno. " + ex);
            }
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst;
                pst = cn.prepareStatement(
                        "delete from familiares where dni_familiar = '" + dni + "' and apellido = '" + apellido + "'");
                //selecciona esos valores de la tabla
                pst.executeUpdate(); //ejecuto lo anterior
            } catch (SQLException ex) {
                System.err.println("Error al eliminar familiar. " + ex);
            }
            
            ObtenerDatosTabla();
        }
        
        
        
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String seleccion = cmb_filtro.getSelectedItem().toString();
        
        Connection cn = Conexion.conectar();
        String ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
        File file = new File(ruta + "/Desktop/Sistema de Registro/Datos de Alumnos/Alumnos " + seleccion + ".xls");
        int row = 0;
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        try {
            workbook = Workbook.createWorkbook(file);

            workbook.createSheet("dato", 0);

            excelSheet = workbook.getSheet(0);
            System.out.println("creando la hoja de excel...");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        Label nombret = new Label(0, row, "NOMBRE");
        Label apellidot = new Label(1, row, "APELLIDO");
        Label dnit = new Label(2, row, "DNI");
        Label fecha_nacimientot = new Label(3, row, "NACIMIENTO");
        Label lugar_nacimientot = new Label(4, row, "LUGAR NACIMIENTO");
        Label domiciliot = new Label(5, row,"DOMICILIO");
        Label localidadt = new Label(6, row, "LOCALIDAD");
        Label nombre_madret = new Label(7, row, "NOMBRE MADRE");
        Label dni_madret = new Label(8, row, "DNI MADRE");
        Label nombre_padret = new Label(9, row, "NOMBRE PADRE");
        Label dni_padret = new Label(10, row, "DNI PADRE");
        Label telefonot = new Label(11, row, "TELEFONO");
        Label telefono2t = new Label(12, row,"OTRO TELEFONO");
        Label numero_escuelat = new Label(13, row, "NUMERO DE ESCUELA");
        Label nombre_escuelat = new Label(14, row, "NOMBRE DE ESCUELA");
        Label gradot = new Label(15, row, "GRADO");
        Label repitiot = new Label(16, row, "¿REPITIÓ?");
        Label grado_repetidot = new Label(17, row, "GRADO REPETIDO");
        Label sangret = new Label(18, row, "GRUPO SANGUÍNEO");
        Label alergiast = new Label(19, row, "ALERGIAS");
        Label coberturat = new Label(20, row, "COBERTURA MÉDICA");
        Label condiciont = new Label(21, row, "CONDICIÓN MÉDICA");
        Label retira_cont = new Label(22, row, "SE RETIRA CON");
        Label observacionest = new Label(23, row, "OBSERVACIONES");
        Label inscripciont = new Label(24, row, "INSCRIPCIÓN PAGA");
        Label cuotat = new Label(25, row, "CUOTA PAGA");
        Label fechat = new Label(26, row, "FECHA INSCRIPCIÓN");
        row++;
        try {
            excelSheet.addCell(nombret);
            excelSheet.addCell(apellidot);
                    excelSheet.addCell(dnit);
                    excelSheet.addCell(fecha_nacimientot);
                    excelSheet.addCell(lugar_nacimientot);
                    excelSheet.addCell(domiciliot);
                    excelSheet.addCell(localidadt);
                    excelSheet.addCell(nombre_madret);
                    excelSheet.addCell(dni_madret);
                    excelSheet.addCell(nombre_padret);
                    excelSheet.addCell(dni_padret);
                    excelSheet.addCell(telefonot);
                    excelSheet.addCell(telefono2t);
                    excelSheet.addCell(numero_escuelat);
                    excelSheet.addCell(nombre_escuelat);
                    excelSheet.addCell(gradot);
                    excelSheet.addCell(repitiot);
                    excelSheet.addCell(grado_repetidot);
                    excelSheet.addCell(sangret);
                    excelSheet.addCell(alergiast);
                    excelSheet.addCell(coberturat);
                    excelSheet.addCell(condiciont);
                    excelSheet.addCell(retira_cont);
                    excelSheet.addCell(observacionest);
                    excelSheet.addCell(inscripciont);
                    excelSheet.addCell(cuotat);
                    excelSheet.addCell(fechat);
        } catch (WriteException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "select nombre,apellido,dni,nacimiento,lugar_nacimiento,"
                    + "domicilio,localidad,nombre_madre,dni_madre,nombre_padre,dni_padre,telefono,"
                    + "telefono2,numero_escuela,nombre_escuela,grado,repitio,grado_repetido,"
                    + "sangre,alergias,cobertura,condicion,retira_con,observaciones,inscripcion,cuota,fecha"
                    + " from alumnos where grado = '" + seleccion + "' order by apellido";
        String sql2 = "select nombre,apellido,dni,nacimiento,lugar_nacimiento,"
                    + "domicilio,localidad,nombre_madre,dni_madre,nombre_padre,dni_padre,telefono,"
                    + "telefono2,numero_escuela,nombre_escuela,grado,repitio,grado_repetido,"
                    + "sangre,alergias,cobertura,condicion,retira_con,observaciones,inscripcion,cuota,fecha"
                    + " from alumnos order by grado,apellido";

        try {
            PreparedStatement pst;
            if(seleccion.equals("Todos")){
                pst = cn.prepareStatement(sql2);
            } else {
                pst = cn.prepareStatement(sql);
            }
            

            ResultSet rs = pst.executeQuery();
            System.out.println("obteniendo registros...");
            while(rs.next()){
                //Number id = new Number(0, row, rs.getLong("Id"));
                Label nombre = new Label(0, row, rs.getString("Nombre"));
                Label apellido = new Label(1, row, rs.getString("Apellido"));
                Number dni = new Number(2, row, rs.getLong("DNI"));
                Number fecha_nacimiento = new Number(3, row, rs.getLong("nacimiento"));
                Label lugar_nacimiento = new Label(4, row, rs.getString("Lugar_nacimiento"));
                Label domicilio = new Label(5, row, rs.getString("Domicilio"));
                Label localidad = new Label(6, row, rs.getString("Localidad"));
                Label nombre_madre = new Label(7, row, rs.getString("Nombre_Madre"));
                Number dni_madre = new Number(8, row, rs.getLong("DNI_Madre"));
                Label nombre_padre = new Label(9, row, rs.getString("Nombre_Padre"));
                Number dni_padre = new Number(10, row, rs.getLong("DNI_Padre"));
                Label telefono = new Label(11, row, rs.getString("Telefono"));
                Label telefono2 = new Label(12, row, rs.getString("Telefono2"));
                Number numero_escuela = new Number(13, row, rs.getLong("Numero_Escuela"));
                Label nombre_escuela = new Label(14, row, rs.getString("Nombre_Escuela"));
                Label grado = new Label(15, row, rs.getString("Grado"));
                Label repitio = new Label(16, row, rs.getString("Repitio"));
                Label grado_repetido = new Label(17, row, rs.getString("Grado_Repetido"));
                Label sangre = new Label(18, row, rs.getString("Sangre"));
                Label alergias = new Label(19, row, rs.getString("Alergias"));
                Label cobertura = new Label(20, row, rs.getString("Cobertura"));
                Label condicion = new Label(21, row, rs.getString("Condicion"));
                Label retira_con = new Label(22, row, rs.getString("retira_con"));
                Label observaciones = new Label(23, row, rs.getString("Observaciones"));
                Label inscripcion = new Label(24, row, rs.getString("Inscripcion"));
                Label cuota = new Label(25, row, rs.getString("Cuota"));
                Label fecha = new Label(26, row, rs.getString("Fecha"));
                row++;

                try {
                    //excelSheet.addCell(id);
                    excelSheet.addCell(nombre);
                    excelSheet.addCell(apellido);
                    excelSheet.addCell(dni);
                    excelSheet.addCell(fecha_nacimiento);
                    excelSheet.addCell(lugar_nacimiento);
                    excelSheet.addCell(domicilio);
                    excelSheet.addCell(localidad);
                    excelSheet.addCell(nombre_madre);
                    excelSheet.addCell(dni_madre);
                    excelSheet.addCell(nombre_padre);
                    excelSheet.addCell(dni_padre);
                    excelSheet.addCell(telefono);
                    excelSheet.addCell(telefono2);
                    excelSheet.addCell(numero_escuela);
                    excelSheet.addCell(nombre_escuela);
                    excelSheet.addCell(grado);
                    excelSheet.addCell(repitio);
                    excelSheet.addCell(grado_repetido);
                    excelSheet.addCell(sangre);
                    excelSheet.addCell(alergias);
                    excelSheet.addCell(cobertura);
                    excelSheet.addCell(condicion);
                    excelSheet.addCell(retira_con);
                    excelSheet.addCell(observaciones);
                    excelSheet.addCell(inscripcion);
                    excelSheet.addCell(cuota);
                    excelSheet.addCell(fecha);
                } catch (WriteException e) {
                    System.err.println(e.getMessage());
                }



            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            workbook.write();
            workbook.close();
            System.out.println("escribiendo en el disco...");
        } catch (IOException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Lo mismo pero con la lista de familiares
        //Se reutilizaran algunas de las variables usadas en el proceso anterior
        cn = Conexion.conectar();
        ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
        file = new File(ruta + "/Desktop/Sistema de Registro/Datos de Alumnos/CuatroVientosFamiliares.xls");
        row = 0;
        excelSheet = null;
        workbook = null;

        try {
            workbook = Workbook.createWorkbook(file);

            workbook.createSheet("dato", 0);

            excelSheet = workbook.getSheet(0);
            System.out.println("creando la hoja de excel...");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
          
        Label apellidoT = new Label(0, row, "APELLIDO");
        Label idT = new Label(1, row, "NOMBRE");
        Label dni_familiarT = new Label(2, row, "DNI DEL FAMILIAR");
        Label nombre_familiarT = new Label(3, row,"NOMBRE DEL FAMILIAR");
        Label parentescoT = new Label(4, row,"PARENTESCO");
        Label edadT = new Label(5, row, "EDAD");
        Label ocupacionT = new Label(6, row, "OCUPACION");
        row++;
        try {
            excelSheet.addCell(apellidoT);   
            excelSheet.addCell(idT);
            excelSheet.addCell(dni_familiarT);
            excelSheet.addCell(nombre_familiarT);
            excelSheet.addCell(parentescoT);
            excelSheet.addCell(edadT);
            excelSheet.addCell(ocupacionT);
        } catch (WriteException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "select id,apellido,dni_familiar,nombre_familiar,parentesco,edad,ocupacion"
                    + " from familiares order by apellido,id,nombre_familiar";

        try {
            
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            System.out.println("obteniendo registros...");
            while(rs.next()){
                Label id = new Label(1, row, rs.getString("Id"));
                Label apellido = new Label(0, row, rs.getString("apellido"));
                Number dni_familiar = new Number(2, row, rs.getLong("Dni_familiar"));
                Label nombre_familiar = new Label(3, row, rs.getString("nombre_familiar"));
                Label parentesco = new Label(4, row, rs.getString("Parentesco"));
                Number edad = new Number(5, row, rs.getLong("Edad"));
                Label ocupacion = new Label(6, row, rs.getString("Ocupacion"));
                row++;


                try {
                    excelSheet.addCell(apellido);   
                    excelSheet.addCell(id);
                    excelSheet.addCell(dni_familiar);
                    excelSheet.addCell(nombre_familiar);
                    excelSheet.addCell(parentesco);
                    excelSheet.addCell(edad);
                    excelSheet.addCell(ocupacion);

                } catch (WriteException e) {
                    System.err.println(e.getMessage());
                }    

            }
            rs.close();
            workbook.write();
            workbook.close();
            System.out.println("escribiendo en el disco...");
            JOptionPane.showMessageDialog(null, "Lista de familiares creada correctamente.");
        } catch (IOException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_estadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_estadisticaActionPerformed
        
        Grafica f1 = new Grafica();
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);

        GraficaNiveles f2 = new GraficaNiveles();
        f2.setLocation(f1.getX() + f1.getWidth(), f1.getY());
        f2.setVisible(true);
        
    }//GEN-LAST:event_jButton_estadisticaActionPerformed

    
    private void cmb_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filtroActionPerformed
        
        String seleccion = cmb_filtro.getSelectedItem().toString();
        String seleccion2 = cmb_filtroNivel.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();
            
            /*
            if (seleccion.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido";
            } else {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' order by apellido";
            }*/
            if (seleccion.equals("Todos") && seleccion2.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido";
            } else {
                if(seleccion.equals("Todos")) {
                    query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where nivel = '" + seleccion2 + "' order by apellido";
                } else {
                    if(seleccion2.equals("Todos")){
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' order by apellido";
                    } else {
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' and nivel = '" + seleccion2 + "' order by apellido";
                    }
                }
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");
            model.addColumn("Nivel");

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
        //cmb_filtroNivel.setSelectedItem("Todos");
        ObtenerDatosTabla();
    }//GEN-LAST:event_cmb_filtroActionPerformed

    private void cmb_filtroNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filtroNivelActionPerformed
        String seleccion = cmb_filtro.getSelectedItem().toString();
        String seleccion2 = cmb_filtroNivel.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();
            /*
            if (seleccion.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido";
            } else {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where nivel = '" + seleccion + "' order by apellido";
            }*/
            if (seleccion.equals("Todos") && seleccion2.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos order by apellido";
            } else {
                if(seleccion.equals("Todos")) {
                    query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where nivel = '" + seleccion2 + "' order by apellido";
                } else {
                    if(seleccion2.equals("Todos")){
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' order by apellido";
                    } else {
                        query = "select apellido, nombre, dni, nombre_escuela, grado, nivel from alumnos where grado = '" + seleccion + "' and nivel = '" + seleccion2 + "' order by apellido";
                    }
                }
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");
            model.addColumn("Nivel");

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
        //cmb_filtro.setSelectedItem("Todos");
        ObtenerDatosTabla();
    }//GEN-LAST:event_cmb_filtroNivelActionPerformed

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
    private javax.swing.JComboBox<String> cmb_filtroNivel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_estadistica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_gestionarAlumnos;
    // End of variables declaration//GEN-END:variables


    public void ObtenerDatosTabla() {
        jTable_gestionarAlumnos.addMouseListener(new MouseAdapter() {
            @Override // para sobreescribir metodos
            public void mouseClicked(MouseEvent e){
               //le indicamos la fila que selecciono el usuario
               int fila_point = jTable_gestionarAlumnos.rowAtPoint(e.getPoint());
               //seleccionamos por defecto la columna 1 (nombre)
               int columna_point = 1;
               
               
               if(fila_point > -1){
                   name = (int) model.getValueAt(fila_point, 2); //nos devuelve el nombre
                   user_update = (String) model.getValueAt(fila_point, 0);
                   System.out.println(name);
                   System.out.println(user_update);
               }
               
            }
        });
    }
    
    public void actualizarTabla(){
        
        String seleccion = cmb_filtro.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equals("Todos")) {
                query = "select apellido, nombre, dni, nombre_escuela, grado from alumnos order by apellido";
            } else {
                query = "select apellido, nombre, dni, nombre_escuela, grado from alumnos where grado = '" + seleccion + "' order by apellido";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_gestionarAlumnos = new JTable(model);
            jScrollPane1.setViewportView(jTable_gestionarAlumnos);

            model.addColumn("Apellido");
            model.addColumn("Nombre");
            model.addColumn("DNI");
            model.addColumn("Escuela");
            model.addColumn("Curso");

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
}


