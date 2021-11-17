package aras;

import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author mjgod
 */
public class InformaciónAlumnos3 extends javax.swing.JFrame {
    int cont = 32, ID;
    // String user_update = "";
    int user_update;
   
    public InformaciónAlumnos3() {
        initComponents();
        
        user_update = GestionarAlumnos.user_update;
        
        setResizable(false);
        setTitle("Sistema de Registro");
        setLocationRelativeTo(null);
        setSize(700,500);
        //cuando se cierra la ventana, termina de ejecutarse el programa
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
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
                ID = rs.getInt("id");
                //Realizo el vaciado de datos en los jtextfield.
                txt_alergias.setText(rs.getString("alergias"));
                txt_cobertura.setText(rs.getString("cobertura"));
                txt_condicion.setText(rs.getString("condicion"));
                txt_retira_con.setText(rs.getString("retira_con"));
                jTextArea_observaciones.setText(rs.getString("observaciones"));
                jComboBox_sangre.setSelectedItem(rs.getString("sangre"));
                
                if("SI".equals(rs.getString("cuota"))){
                        jRadioButton_cuota.setSelected(true);
                } else {
                    jRadioButton4.setSelected(true);
                }
                
                if("SI".equals(rs.getString("inscripcion"))){
                    jRadioButton_inscripcion.setSelected(true);
                } else {
                    jRadioButton2.setSelected(true);
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
    
    public static String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_alergias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cobertura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_condicion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton_inscripcion = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton_cuota = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jComboBox_sangre = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_retira_con = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_observaciones = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información Médica");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alergias:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        txt_alergias.setBackground(new java.awt.Color(51, 102, 255));
        txt_alergias.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_alergias.setForeground(new java.awt.Color(255, 255, 255));
        txt_alergias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_alergias.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_alergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 210, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cobertura médica:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txt_cobertura.setBackground(new java.awt.Color(51, 102, 255));
        txt_cobertura.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_cobertura.setForeground(new java.awt.Color(255, 255, 255));
        txt_cobertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cobertura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_cobertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Padece de alguna condición médica:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        txt_condicion.setBackground(new java.awt.Color(51, 102, 255));
        txt_condicion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_condicion.setForeground(new java.awt.Color(255, 255, 255));
        txt_condicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_condicion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_condicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Paga Inscripción:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Grupo sanguíneo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        buttonGroup1.add(jRadioButton_inscripcion);
        jRadioButton_inscripcion.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_inscripcion.setText("SI");
        getContentPane().add(jRadioButton_inscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("NO");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Paga Cuota:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        buttonGroup2.add(jRadioButton_cuota);
        jRadioButton_cuota.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_cuota.setText("SI");
        getContentPane().add(jRadioButton_cuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("NO");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        jComboBox_sangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-", "0+", "A-", "A+", "B-", "B+", "AB" }));
        getContentPane().add(jComboBox_sangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observaciones:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        txt_retira_con.setBackground(new java.awt.Color(51, 102, 255));
        txt_retira_con.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_retira_con.setForeground(new java.awt.Color(255, 255, 255));
        txt_retira_con.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_retira_con.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_retira_con, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 210, 25));

        jTextArea_observaciones.setColumns(20);
        jTextArea_observaciones.setRows(5);
        jScrollPane1.setViewportView(jTextArea_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 210, 90));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Se retira con:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 140, 50));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Finalizar >");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 140, 50));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        InformaciónAlumnos4.informacionAlumnos2.setVisible(true);
        InformaciónAlumnos2.informacionAlumnos3.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String nombre, apellido, lugar, fecha, localidad, domicilio, nombre_madre, nombre_padre, telefono, telefono2, nombre_escuela, grado, repitio, grado_repetido, alergias, cobertura, condicion, sangre, retira_con, observaciones, inscripcion, cuota;
        int dni, dni_madre, dni_padre, numero_escuela;
        
        nombre = InformaciónAlumnos1.nombre;
        apellido = InformaciónAlumnos1.apellido;
        nombre_madre = InformaciónAlumnos1.nombre_madre;
        nombre_padre = InformaciónAlumnos1.nombre_padre;
        lugar = InformaciónAlumnos1.lugar;
        fecha = InformaciónAlumnos1.fecha;
        localidad = InformaciónAlumnos1.localidad;
        domicilio = InformaciónAlumnos1.domicilio;
        telefono = InformaciónAlumnos1.telefono;
        telefono2 = InformaciónAlumnos1.telefono2;
        dni = Integer.parseInt(InformaciónAlumnos1.dni);
        dni_madre = Integer.parseInt(InformaciónAlumnos1.dni_madre);
        dni_padre = Integer.parseInt(InformaciónAlumnos1.dni_padre);
        
        // Actualizo la tabla de familiares
        InformaciónAlumnos1.informacionAlumnos4.actualizarFamiliares();
        
        nombre_escuela = InformaciónAlumnos2.nombre_escuela;
        numero_escuela = Integer.parseInt(InformaciónAlumnos2.numero_escuela);
        grado = InformaciónAlumnos2.grado;
        repitio = InformaciónAlumnos2.repitio;
        grado_repetido = InformaciónAlumnos2.grado_repetido;
        
        alergias = txt_alergias.getText().trim();
        cobertura = txt_cobertura.getText().trim();
        condicion = txt_condicion.getText().trim();
        retira_con = txt_retira_con.getText().trim();
        observaciones = jTextArea_observaciones.getText();
        sangre = jComboBox_sangre.getSelectedItem().toString();
        
        if(jRadioButton_inscripcion.isSelected()){
            inscripcion = "SI";
        } else {
            inscripcion = "NO";
        }
        
        if(jRadioButton_cuota.isSelected()){
            cuota = "SI";
        } else {
            cuota = "NO";
        }
        
        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("update alumnos set id=?,nombre=?,apellido=?,dni=?,nacimiento=?,lugar_nacimiento=?,"
                    + "domicilio=?,localidad=?,nombre_madre=?,dni_madre=?,nombre_padre=?,dni_padre=?,telefono=?,"
                    + "telefono2=?,numero_escuela=?,nombre_escuela=?,grado=?,repitio=?,grado_repetido=?,"
                    + "sangre=?,alergias=?,cobertura=?,condicion=?,retira_con=?,observaciones=?,inscripcion=?,cuota=?"
                    + " where dni ='" + user_update + "'");
            
            pst2.setInt(1, ID);
            pst2.setString(2, nombre);
            pst2.setString(3, apellido);
            pst2.setInt(4, dni);
            pst2.setString(5, fecha);
            pst2.setString(6, lugar);
            pst2.setString(7, domicilio);
            pst2.setString(8, localidad);
            pst2.setString(9, nombre_madre);
            pst2.setInt(10, dni_madre);
            pst2.setString(11, nombre_padre);
            pst2.setInt(12, dni_padre);
            pst2.setString(13, telefono);
            pst2.setString(14, telefono2);
            pst2.setInt(15, numero_escuela);
            pst2.setString(16, nombre_escuela);
            pst2.setString(17, grado);
            pst2.setString(18, repitio);
            pst2.setString(19, grado_repetido);
            pst2.setString(20, sangre);
            pst2.setString(21, alergias);
            pst2.setString(22, cobertura);
            pst2.setString(23, condicion);
            pst2.setString(24, retira_con);
            pst2.setString(25, observaciones);
            pst2.setString(26, inscripcion);
            pst2.setString(27, cuota);
            //pst2.setString(28, fechaActual()); //despues cambiar por fecha de inscripcion
            
            cont++;
                        
            pst2.executeUpdate();
            cn2.close();
            //this.dispose();
                        
            } catch (SQLException e) {
                System.err.println("Error en Registrar alumno. " + e);
                JOptionPane.showMessageDialog(null, "¡ERROR al registrar alumno!, contacte al administrador.");
    }//GEN-LAST:event_jButton2ActionPerformed
    
        int input = JOptionPane.showConfirmDialog(null, "¿Quiere imprimir la ficha de inscripción?");
        // 0=yes, 1=no, 2=cancel
        System.out.println(input);
        
        if(input == 0) {
            Document documento = new Document(); //creo objeto de la clase document
            try {
                String ruta = System.getProperty("user.home"); //ruta donde se guarda el archivo
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Ficha" + apellido + nombre + ".pdf")); //complementamos la ruta

                com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerFicha.jpg"); //agrego el header
                header.scaleToFit(300, 900); //tamaño del header
                header.setAlignment(Chunk.ALIGN_CENTER); //posicion centrada del header

                Paragraph parrafo = new Paragraph(); //creo el parrafo del pdf
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.add("Ficha de Inscripción\n\n");
                parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)); //le doy la fuente

                documento.open();
                documento.add(header); //le agrego los elementos al documento
                documento.add(parrafo);

                documento.add(new Paragraph("Fecha de inscripción: " + fechaActual() + "\n"));
                documento.add(new Paragraph("Nombre: " + nombre + "                Apellido: " + apellido + "\n"));
                //documento.add(new Paragraph("Apellido: " + apellido));
                documento.add(new Paragraph("DNI: " + dni + "                Lugar de nacimiento: " + lugar + "                Fecha de nacimiento: " + fecha + "\n"));
                //documento.add(new Paragraph("Lugar de nacimiento: " + lugar));
                //documento.add(new Paragraph("Fecha de nacimiento: " + fecha));
                documento.add(new Paragraph("Domicilio: " + domicilio + "                Localidad: " + localidad + "\n"));
                //documento.add(new Paragraph("Localidad: " + localidad));
                documento.add(new Paragraph("Nombre de la Madre: " + nombre_madre + "                DNI: " + dni_madre + "\n"));
                //documento.add(new Paragraph("DNI: " + dni_madre));
                documento.add(new Paragraph("Nombre del Padre: " + nombre_padre + "                DNI: " + dni_padre + "\n"));
                //documento.add(new Paragraph("DNI: " + dni_padre));
                documento.add(new Paragraph("Teléfono de contacto: " + telefono + "\n"));
                documento.add(new Paragraph("Otro teléfono de contacto: " + telefono2 + "\n\n"));

                documento.add(new Paragraph("Grupo familiar del alumno:\n\n"));
                PdfPTable tabla = new PdfPTable(4); //agrego las columnas


                tabla.addCell("NOMBRE Y APELLIDO");
                tabla.addCell("PARENTESCO");
                tabla.addCell("EDAD");
                tabla.addCell("OCUPACION");

                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select nombre_familiar, parentesco, edad, ocupacion from familiares where id = '" + nombre +"'");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        do {                        

                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));

                        } while (rs.next());
                        documento.add(tabla);
                    }

                } catch (SQLException e) {
                    System.out.println("Error al generar lista de alumnos. " + e);
                }

                documento.add(new Paragraph("Nombre de Escuela a la que asiste: " + nombre_escuela + "                Número: " + numero_escuela + "\n"));
                //documento.add(new Paragraph("Número: " + numero_escuela));
                documento.add(new Paragraph("Grado/Curso: " + grado + "                Repitió grado alguna vez: " + repitio + "                ¿Qué Grado? " + grado_repetido + "\n"));
                //documento.add(new Paragraph("Repitió grado alguna vez: " + repitio));
                //documento.add(new Paragraph("¿Qué Grado repitió? " + grado_repetido));

                documento.add(new Paragraph("Grupo sanguíneo: " + sangre + "               Alergias: " + alergias + "                Cobertura médica: " + cobertura + "\n"));
                //documento.add(new Paragraph("Alergias: " + alergias));
                //documento.add(new Paragraph("Cobertura médica: " + cobertura));
                documento.add(new Paragraph("Padece de alguna condición médica: " + condicion + "\n"));
                documento.add(new Paragraph("Se retira acompañado de: " + retira_con + "\n"));
                documento.add(new Paragraph("Observaciones: " + observaciones + "\n"));
                documento.add(new Paragraph("Paga Inscripción: " + inscripcion + "                Paga Cuota: " + cuota + "\n\n"));
                //documento.add(new Paragraph("Paga Cuota: " + cuota));


                Paragraph parrafo2 = new Paragraph(); //creo el parrafo del pdf
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("________________________________________________________");
                documento.add(parrafo2);

                Paragraph terminos = new Paragraph("\nPor la presente, autorizo a mi hijo que concurra y participe en todas las actividades"
                        + " en el Centro Educativo Cuatro Vientos. Dejo constancia que estoy de acuerdo con los términos "
                        + "y condiciones de la inscripción del alumno.\n");
                terminos.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
                documento.add(terminos);

                documento.add(new Paragraph("Firma Madre, Padre o Tutor:\n"));
                documento.add(new Paragraph("Aclaración y Parentesco:\n"));
                documento.add(new Paragraph("DNI:\n"));


                documento.close();
                JOptionPane.showMessageDialog(null, "Ficha de alumno creada correctamente.");



            } catch (Exception e) {
                System.out.println("Error al generar PDF. " + e);
            }
        }
        this.dispose();
        InformaciónAlumnos4.informacionAlumnos2.dispose();
        InformaciónAlumnos1.informacionAlumnos4.dispose();
        //InformaciónAlumnos1.CerrarVentana();
        
        //String[] args = null;
        //Login.main(args);
        //Administrador administrador = new Administrador();
        //administrador.setVisible(true);
        
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
            java.util.logging.Logger.getLogger(InformaciónAlumnos3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformaciónAlumnos3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InformaciónAlumnos3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_sangre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton_cuota;
    private javax.swing.JRadioButton jRadioButton_inscripcion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_observaciones;
    private javax.swing.JTextField txt_alergias;
    private javax.swing.JTextField txt_cobertura;
    private javax.swing.JTextField txt_condicion;
    private javax.swing.JTextField txt_retira_con;
    // End of variables declaration//GEN-END:variables
}
