/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import Config.Koneksi;
import img.Tes;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;
import javax.imageio.ImageIO;

/**
 *
 * @author surya
 */
public class Gameplay extends javax.swing.JFrame {

    /**
     * Creates new form Gameplay
     */
    private static int id = 10;
    private static int chance = 0;
    private static String jawaban = "";
    private static String namaGambar = "";
    private static int level = 0;
    private static String pathfile = "src\\";
    private static String pathimage = pathfile+"img\\";

    public Gameplay(int id_level, int ch) {
        id = id_level;
        java.sql.Connection conn = Koneksi.getKoneksi();
        try {
            java.sql.Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM tb_gambar WHERE id_gambar = " + id;
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            res.next();

            String jaw = res.getString("jawaban_gambar");
            jawaban = jaw;
            namaGambar = res.getString("gambar");
            String lvl = res.getString("level_gambar");
            
            if (lvl.equalsIgnoreCase("Easy")) {
                level = 1;
            }else if (lvl.equalsIgnoreCase("Normal")) {
                level = 2;
            }else if(lvl.equalsIgnoreCase("Hard")) {
                level = 3;
            }else{
                level = 0;
            }
            chance = ch;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        User us = new User();
////        us.isHaveId();
//        if (us.getId() == null) {
//            Login log = new Login();
//            log.setVisible(true);
//        }else{
//             SwingUtilities.invokeLater(() -> showGui());   
//        }
//        /* Create and display the form */
//    }
//    
    

    static void showGui() {
        JFrame frame = new JFrame("Grid BagLayout");
        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new java.awt.Color(0, 0, 0));
        frame.setResizable(false);
        frame.setUndecorated(true);

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 500, 50);
        header.setBackground(new java.awt.Color(48, 211, 129));

        Insets insets = header.getInsets();

        for (int i = 1; i <= chance; i++) {

            JLabel nyawa = new JLabel();
            nyawa.setIcon(new javax.swing.ImageIcon(pathimage+"heart.png"));
            Dimension size = nyawa.getPreferredSize();
            nyawa.setBounds(10 + (i - 1) * 35, 10 + insets.top, size.width, size.height);
            nyawa.setForeground(new java.awt.Color(250, 4, 4));
            header.add(nyawa);
        }

        JLabel brain = new JLabel("BrainSnap");
        brain.setFont(new java.awt.Font("Ravie", 1, 20)); // NOI18N
        brain.setForeground(new java.awt.Color(246, 255, 4));
        brain.setBounds(170 + insets.left, 10 + insets.top, 200, 30);
        header.add(brain);

        JLabel menu = new JLabel("Back");
        menu.setFont(new java.awt.Font("Ravie", 1, 15)); // NOI18N
        menu.setForeground(new java.awt.Color(213, 139, 59));
        menu.setBounds(400 + insets.right, 10 + insets.top, 100, 30);
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        header.add(menu);
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
            }
        });

        JPanel contain = new JPanel();
        contain.setLayout(null);

        //path dan copy gambar
        String path = pathfile+"imgdtbase\\";
//        path = Tes.class.getResource("Tes.class").getPath();
//        path = path.substring(1, path.length() - 9);
//        System.out.println(path);
//
//        ImageIcon imageIcon = new ImageIcon();

        JLabel gambar = new JLabel();
        gambar.setIcon(new ImageIcon(path + namaGambar));
        gambar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(6, 110, 8), 1, true));
        Dimension size = gambar.getPreferredSize();
        gambar.setBounds(30, 60, 350, 350);
        contain.setBounds(35, 0, 400, 430);
        contain.add(gambar);

        JPanel inputBox = new JPanel();
        inputBox.setLayout(null);

        JLabel hint = new JLabel();
        hint.setIcon(new javax.swing.ImageIcon(pathimage+"hint.png"));
        hint.setBounds(30, 450, 35, 35);
        hint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, jawaban, "Jawaban", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(pathimage+"hint.png"));
            }
        });
        inputBox.add(hint);

        JTextField input = new JTextField();
        input.setFont(new java.awt.Font("Arial", 1, 12));
        input.setForeground(new java.awt.Color(255, 255, 255));
        input.setBackground(new java.awt.Color(48, 211, 129));

        input.setColumns(30);
        input.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(6, 110, 8), 1, true));
        input.setBorder(BorderFactory.createCompoundBorder(input.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        input.setBounds(70, 450, 340, 35);
        inputBox.add(input);

        JLabel send = new JLabel();
        send.setIcon(new javax.swing.ImageIcon(pathimage+"send.png"));
        send.setBounds(415, 450, 35, 35);
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         
        
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (input.getText().equalsIgnoreCase(jawaban)) {
                    JOptionPane.showMessageDialog(null, "Jawabannya Benar", "Benarr", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(pathimage+"benar.gif"));
                    frame.dispose();
                    User us = Login.us;
                    
                    System.out.println("ini id : " + us.getId() + " ini score : " + us.getScore() + "ini level : " + level);
                    java.sql.Connection conn = Koneksi.getKoneksi();
                    try {
                        //mengupdate data gambar sesuai dengan statement 2 dan menjalankan statement 3
                        String update = "UPDATE tb_user SET score=? WHERE id_user = ?";
                        PreparedStatement stmt3 = conn.prepareStatement(update);

                        //mengubah nama file dari gambar
                        stmt3.setInt(1, Login.us.getScore() + level);
                        stmt3.setString(2, us.getId());
                        Login.us.setScore(Login.us.getScore() + level);

                        stmt3.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                } else {
                    chance -= 1;
                    if (chance > 0) {
                        JOptionPane.showMessageDialog(null, "Jawabannya Salah", "Salah", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(pathimage+"salah.gif"));

                        frame.dispose();
                        // Membuka frame baru
                        showGui();
                    } else {
                        // Jika kesempatan habis, tambahkan logika lain di sini

                        JOptionPane.showMessageDialog(null, "TULUULLL", "Game over", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(pathimage+"salah.gif"));
                        Difficulty dif = new Difficulty();
                        frame.dispose();
                        dif.setVisible(true);
                    }
                }
            }
        });
        inputBox.add(send);

        frame.add(header);
        frame.add(contain);
        frame.add(inputBox);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
