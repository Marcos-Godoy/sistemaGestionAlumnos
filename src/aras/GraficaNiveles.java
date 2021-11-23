/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aras;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author mjgod
 */
public class GraficaNiveles extends javax.swing.JFrame {

    int[] vector_niveles_cantidad = new int[20];
    String[] vector_niveles_nombre = new String[20];
    String[] nivelesExistentes = new String[11];
    int hp, lenovo, dell, acer, apple, toshiba, brother, samsung, asus, alienware, xerox, primero;
    int primerAnio, segundoAnio, tercerAnio, cuartoAnio, quintoAnio;
    /**
     * Creates new form GraficaEstatus
     */
    public GraficaNiveles() {
        
        initComponents();

        setTitle("Estadistica");
        setSize(550, 450);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/fondo5.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        
        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select grado, count(grado) as Grados from alumnos group by grado");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_niveles_nombre[posicion] = (rs.getString(1)).substring(0, 4);
                    vector_niveles_cantidad[posicion] = rs.getInt(2);

                    if (vector_niveles_nombre[posicion].equalsIgnoreCase("1º g")) {
                        primero = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("2º g")) {
                        alienware = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("3º g")) {
                        apple = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("4º g")) {
                        asus = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("5º g")) {
                        brother = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("6º g")) {
                        dell = vector_niveles_cantidad[posicion];
                    } else if (vector_niveles_nombre[posicion].equalsIgnoreCase("7º g")) {
                        hp = vector_niveles_cantidad[posicion];
                    }else if (vector_niveles_nombre[posicion].equalsIgnoreCase("1º a")) {
                        primerAnio = vector_niveles_cantidad[posicion];
                    }else if (vector_niveles_nombre[posicion].equalsIgnoreCase("2º a")) {
                        segundoAnio = vector_niveles_cantidad[posicion];
                    }else if (vector_niveles_nombre[posicion].equalsIgnoreCase("3º a")) {
                        tercerAnio = vector_niveles_cantidad[posicion];
                    }else if (vector_niveles_nombre[posicion].equalsIgnoreCase("4º a")) {
                        cuartoAnio = vector_niveles_cantidad[posicion];
                    }else if (vector_niveles_nombre[posicion].equalsIgnoreCase("5º a")) {
                        quintoAnio = vector_niveles_cantidad[posicion];
                    }
                    posicion++;
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Error en la consulta. " + e);
            JOptionPane.showMessageDialog(null, "ERROR en consultar datos, contacte al administrador.");
        }

        repaint();
    }

    @Override
    public Image getIconImage() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alumnos por curso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 458));

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
            java.util.logging.Logger.getLogger(GraficaNiveles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaNiveles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaNiveles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaNiveles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaNiveles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        int total = primero + alienware + apple + asus + brother + dell + hp + primerAnio + segundoAnio + tercerAnio + cuartoAnio + quintoAnio;
        System.out.println(total);
        
        int grados_pg = primero * 360 / total;
        int grados_sg = alienware * 360 / total;
        int grados_apple = apple * 360 / total;
        int grados_asus = asus * 360 / total;
        int grados_brother = brother * 360 / total;
        int grados_dell = dell * 360 / total;
        int grados_hp = hp * 360 / total;
        int grados_pa = primerAnio * 360 / total;
        int grados_sa = segundoAnio * 360 / total;
        int grados_ta = tercerAnio * 360 / total;
        int grados_ca = cuartoAnio * 360 / total;
        int grados_qa = quintoAnio * 360 / total;
        
        g.setColor(new Color(254,000,000));
        g.fillArc(25, 100, 270, 270, 0, grados_pg);
        g.fillRect(310,120,20,20);
        g.drawString(primero + " primer grado", 340, 135);
        
        g.setColor(new Color(0,255,0));
        g.fillArc(25, 100, 270, 270, grados_pg, grados_sg);
        g.fillRect(310,150,20,20);
        g.drawString(alienware + " segundo grado", 340, 165);
        
        g.setColor(new Color(0,255,255));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg, grados_apple);
        g.fillRect(310,180,20,20);
        g.drawString(apple + " tercer grado", 340, 195);
        
        g.setColor(new Color(55,0,255));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple, grados_asus);
        g.fillRect(310,210,20,20);
        g.drawString(asus + " cuarto grado", 340, 225);
        
        g.setColor(new Color(197,29,52));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus, grados_brother);
        g.fillRect(310,240,20,20);
        g.drawString(brother + " quinto grado", 340, 255);
        
        g.setColor(new Color(52,62,64));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother, grados_dell);
        g.fillRect(310,270,20,20);
        g.drawString(dell + " sexto grado", 340, 285);
        
        g.setColor(new Color(21,42,160));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell, grados_hp);
        g.fillRect(310,300,20,20);
        g.drawString(hp + " septimo grado", 340, 315);
        
        g.setColor(new Color(10,10,10));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp, grados_pa);
        g.fillRect(310,330,20,20);
        g.drawString(primerAnio + " primer año", 340, 345);
        
        g.setColor(new Color(45,87,44));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_pa, grados_sa);
        g.fillRect(430,120,20,20);
        g.drawString(segundoAnio + " segundo año", 460, 135);
        
        
        g.setColor(new Color(114,20,034));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_pa + grados_sa, grados_ta);
        g.fillRect(430,150,20,20);
        g.drawString(tercerAnio + " tercer año", 460, 165);
        
        g.setColor(new Color(93,173,226));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_pa + grados_sa + grados_ta, grados_ca);
        g.fillRect(430,180,20,20);
        g.drawString(cuartoAnio + " cuarto año", 460, 195);
        
        g.setColor(new Color(48,132,70));
        g.fillArc(25, 100, 270, 270, grados_pg + grados_sg + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp + grados_pa + grados_sa + grados_ta + grados_ca, grados_qa);
        g.fillRect(430,210,20,20);
        g.drawString(quintoAnio + " quinto año", 460, 225);
        
        
    }
    
}
