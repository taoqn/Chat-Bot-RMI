/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmiserver.*;

/**
 *
 * @author Administrator
 */
public class FrameClient extends javax.swing.JFrame {

    public MainC3online m;
    public ServerInterFace server;
    public ClientInterFace client;

    /**
     * Creates new form FrameClient
     */
    public FrameClient() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTaiKhoan = new javax.swing.JTextField();
        jPasswordLogin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtnDangNhap = new javax.swing.JButton();
        jBtnDangKy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chát Online 3 Miền - Login");
        setBackground(new java.awt.Color(255, 51, 51));

        jTaiKhoan.setText("tao");

        jPasswordLogin.setText("123456");

        jLabel1.setText("Tài Khoản");

        jLabel2.setText("Mật Khẩu");

        jBtnDangNhap.setText("Đăng Nhập");
        jBtnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDangNhapActionPerformed(evt);
            }
        });

        jBtnDangKy.setText("Đăng Ký");
        jBtnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDangKyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Vivaldi", 0, 48)); // NOI18N
        jLabel3.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTaiKhoan)
                    .addComponent(jPasswordLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jBtnDangNhap)
                .addGap(18, 18, 18)
                .addComponent(jBtnDangKy)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(93, 93, 93))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnDangKy, jBtnDangNhap});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDangKy)
                    .addComponent(jBtnDangNhap))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDangNhapActionPerformed
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 1099);
            server = (ServerInterFace) r.lookup("rmi://localhost/ABC");
            client = new ClientImpl(jTaiKhoan.getText(), jPasswordLogin.getText(), null, null, null, null, null);
            if (server.loginAccountServer(client)) {
                m = new MainC3online(this);
                m.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hay mật khẩu không đúng, hoặc tài khoản này đã đăng nhập vào hệ thống !.");
                jTaiKhoan.requestFocus();
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối tới Server !.");
            Logger.getLogger(FrameClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnDangNhapActionPerformed

    private void jBtnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDangKyActionPerformed
        FrameRegistry fr = new FrameRegistry(this);
        jBtnDangKy.setEnabled(false);
        fr.setVisible(true);
    }//GEN-LAST:event_jBtnDangKyActionPerformed

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
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnDangKy;
    private javax.swing.JButton jBtnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPasswordField jPasswordLogin;
    public javax.swing.JTextField jTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
