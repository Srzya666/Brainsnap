/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import Config.Koneksi;
import static Game.Gameplay.showGui;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author surya
 */
public class LeaderBoard extends javax.swing.JFrame {

    /**
     * Creates new form LeaderBoard
     */
    public LeaderBoard() {
        JFrame frame = new JFrame("Grid BagLayout");
        frame.setSize(453, 302);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/IMG_1882.JPG")));
        background.setLayout(null);
        background.setBounds(0, 0, 1000, 1550);

        JLabel close = new JLabel("X");
        close.setFont(new java.awt.Font("Ravie", 1, 15));
        close.setForeground(new java.awt.Color(10, 19, 133));
        close.setBounds(425, 7, 30, 30);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
            }
        });
        background.add(close);

        JLabel brain = new JLabel("Leaderboard");
        brain.setFont(new java.awt.Font("Ravie", 1, 23));
        brain.setForeground(new java.awt.Color(246, 255, 4));
        brain.setBounds(130, 70, 250, 30);
        background.add(brain);
        
        //koneksi sql, select dan ordering berdasarkan skor terbesar ke terkecil data max 5

        java.sql.Connection conn = Koneksi.getKoneksi();
        try {
            java.sql.Statement stmt = conn.createStatement();
            String SQL = "select * from tb_user WHERE role = 'user' ORDER BY score DESC LIMIT 5";
            java.sql.ResultSet res = stmt.executeQuery(SQL);

            int no = 1;

            while (res.next()) {

                String nickname = res.getString("nickname");
                int score = res.getInt("score");
                JLabel player = new JLabel("#" + no + "      " + nickname + "         " + score);
                player.setFont(new Font("Ravie", Font.BOLD, 16));
                player.setForeground(Color.white);
                // Menentukan posisi dan ukuran label secara absolut
                player.setBounds(120, 80 + (no - 1) * 30, 230, 60);
                background.add(player);

                no++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        frame.add(background);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
        setUndecorated(true);

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
        setLocationRelativeTo(null);
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
//            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        /* Create and display the form */
//
//        User us = new User();
//
//        if (us.getId() == null) {
//            Login log = new Login();
//            log.setVisible(true);
//        } else {
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    new LeaderBoard().setVisible(true);
//                }
//            });
//
//        }
//
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
