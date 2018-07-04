/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;
import rmiserver.*;

/**
 *
 * @author Administrator
 */
public class FrameChatGroup extends javax.swing.JFrame {

    public MainC3online mc3o;
    public ClientInterFace client2;

    private boolean chuot = false;

    public FrameChatGroup(MainC3online m) throws RemoteException {
        initComponents();
        mc3o = m;
        mc3o.fc.client.setChatGroup(this);
        updateList(m.subServer.getClientSubServer());
        switch (m.subServer.getNameSubServer()) {
            case "HaNoi":
                jKhungHienThiChat.setText("Chào mừng bạn đến cộng đồng chát Hà Nội !");
                this.setTitle("User: " + mc3o.fc.client.getNickName() + " - Cộng Đồng Người Hà Nội");
                break;
            case "DaNang":
                jKhungHienThiChat.setText("Chào mừng bạn đến cộng đồng chát Đà Nẵng !");
                this.setTitle("User: " + mc3o.fc.client.getNickName() + " - Cộng Đồng Người Đà Nẵng");
                break;
            case "HCM":
                jKhungHienThiChat.setText("Chào mừng bạn đến cộng đồng chát Sài Gòn !");
                this.setTitle("User: " + mc3o.fc.client.getNickName() + " - Cộng Đồng Người Sài Gòn");
                break;
        }
        jScrollKhungHienThi.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!chuot) {
                    e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                } else {
                    e.getAdjustable().setValue(e.getAdjustable().getValue());
                }
            }
        });
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jKhungSoanNoiDungChat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDanhSachChat = new javax.swing.JList<>();
        jButtonChat = new javax.swing.JButton();
        jScrollKhungHienThi = new javax.swing.JScrollPane();
        jKhungHienThiChat = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelHienThiNguoiChat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jKhungSoanNoiDungChat.setColumns(20);
        jKhungSoanNoiDungChat.setRows(5);
        jKhungSoanNoiDungChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jKhungSoanNoiDungChatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jKhungSoanNoiDungChat);

        jDanhSachChat.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jDanhSachChatValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jDanhSachChat);

        jButtonChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/237273-Keyboard_enter_3-512.png"))); // NOI18N
        jButtonChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChatActionPerformed(evt);
            }
        });

        jKhungHienThiChat.setEditable(false);
        jKhungHienThiChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jKhungHienThiChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jKhungHienThiChatMouseExited(evt);
            }
        });
        jScrollKhungHienThi.setViewportView(jKhungHienThiChat);

        jLabel1.setText("NickName : ");

        jLabelHienThiNguoiChat.setBackground(new java.awt.Color(51, 255, 153));
        jLabelHienThiNguoiChat.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelHienThiNguoiChat.setForeground(new java.awt.Color(51, 51, 255));
        jLabelHienThiNguoiChat.setText("\"\"");
        jLabelHienThiNguoiChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHienThiNguoiChatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonChat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHienThiNguoiChat))
                    .addComponent(jScrollKhungHienThi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollKhungHienThi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelHienThiNguoiChat)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonChat, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChatActionPerformed
        sendToClientGroup();
    }//GEN-LAST:event_jButtonChatActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            mc3o.subServer.disClientSubServer(mc3o.fc.client);
            mc3o.subServer = null;
            mc3o.fc.client.setChatGroup(null);
        } catch (RemoteException ex) {
            Logger.getLogger(FrameChatGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        mc3o.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jDanhSachChatValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jDanhSachChatValueChanged
        if (!evt.getValueIsAdjusting()) {
            try {
                client2 = mc3o.subServer.getClientSubServer(jDanhSachChat.getSelectedIndex());
                if (client2 != null) {
                    if (!client2.getID().equals(mc3o.fc.client.getID())) {
                        jLabelHienThiNguoiChat.setText("\"" + client2.getNickName() + "\"");
                        jKhungSoanNoiDungChat.requestFocus();
                    } else {
                        client2 = null;
                        jLabelHienThiNguoiChat.setText("\"\"");
                        jDanhSachChat.clearSelection();
                    }
                }
            } catch (RemoteException ex) {
                mc3o.setVisible(true);
                this.dispose();
                Logger.getLogger(FrameChatGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jDanhSachChatValueChanged

    private void jLabelHienThiNguoiChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHienThiNguoiChatMouseClicked
        client2 = null;
        jLabelHienThiNguoiChat.setText("\"\"");
        jDanhSachChat.clearSelection();
    }//GEN-LAST:event_jLabelHienThiNguoiChatMouseClicked

    private void jKhungSoanNoiDungChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jKhungSoanNoiDungChatKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) && ((evt.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            sendToClientGroup();
        }
    }//GEN-LAST:event_jKhungSoanNoiDungChatKeyPressed

    private void jKhungHienThiChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKhungHienThiChatMouseEntered
        chuot = true;
    }//GEN-LAST:event_jKhungHienThiChatMouseEntered

    private void jKhungHienThiChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKhungHienThiChatMouseExited
        chuot = false;
    }//GEN-LAST:event_jKhungHienThiChatMouseExited

    public void closeGroupChat() throws RemoteException {
        JOptionPane.showMessageDialog(this, "[Tin nhắn hệ thống] Bạn đã vi phạm nội quy khi chat, vui lòng quay lại sau 5 phút.");
        mc3o.fc.client.setChatGroup(null);
        mc3o.setVisible(true);
        this.dispose();
    }

    public void updateList(Vector v) throws RemoteException {
        DefaultListModel<String> listModel = new DefaultListModel();
        if (!v.isEmpty()) {
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                ClientInterFace c = (ClientInterFace) e.nextElement();
                listModel.addElement("[ID: " + c.getID() + "] - " + c.getNickName());
            }
            jDanhSachChat.setModel(listModel);
        }
    }

    public void sendGroup(ClientInterFace c, String x, boolean p) throws BadLocationException, RemoteException {
        StyledDocument doc = jKhungHienThiChat.getStyledDocument();
        if (c.getID().equals(mc3o.fc.client.getID())) {
            SimpleAttributeSet keyWordNick = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWordNick, Color.BLUE);
            StyleConstants.setBackground(keyWordNick, Color.WHITE);
            StyleConstants.setBold(keyWordNick, true);
            if (p) {
                doc.insertString(doc.getLength(), "\n[" + mc3o.fc.client.getNickName() + " ==> " + client2.getNickName() + "] : ", keyWordNick);
            } else {
                doc.insertString(doc.getLength(), "\n" + c.getNickName() + " : ", keyWordNick);
            }
            SimpleAttributeSet keyWordMsg = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWordMsg, Color.BLACK);
            StyleConstants.setBackground(keyWordMsg, Color.WHITE);
            StyleConstants.setBold(keyWordMsg, true);
            doc.insertString(doc.getLength(), x, keyWordMsg);
        } else {
            SimpleAttributeSet keyWordNick = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWordNick, Color.DARK_GRAY);
            StyleConstants.setBackground(keyWordNick, Color.WHITE);
            StyleConstants.setBold(keyWordNick, true);
            if (p) {
                doc.insertString(doc.getLength(), "\n[" + c.getNickName() + " ==> " + mc3o.fc.client.getNickName() + "] : ", keyWordNick);
            } else {
                doc.insertString(doc.getLength(), "\n" + c.getNickName() + " : ", keyWordNick);
            }
            SimpleAttributeSet keyWordMsg = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWordMsg, Color.BLACK);
            StyleConstants.setBackground(keyWordMsg, Color.WHITE);
            StyleConstants.setBold(keyWordMsg, false);
            doc.insertString(doc.getLength(), x, keyWordMsg);
        }
    }

    public void sendToClientGroup() {
        try {
            if (client2 != null) {
                mc3o.fc.client.sendMsgClient(mc3o.fc.client, jKhungSoanNoiDungChat.getText(), true);
                client2.sendMsgClient(mc3o.fc.client, jKhungSoanNoiDungChat.getText(), true);
            } else {
                Enumeration e = mc3o.subServer.getClientSubServer().elements();
                while (e.hasMoreElements()) {
                    ClientInterFace c2 = (ClientInterFace) e.nextElement();
                    c2.sendMsgClient(mc3o.fc.client, jKhungSoanNoiDungChat.getText(), false);
                }
            }
            jKhungSoanNoiDungChat.setText("");
            jKhungSoanNoiDungChat.requestFocus();
        } catch (RemoteException ex) {
            Logger.getLogger(FrameChatGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChat;
    private javax.swing.JList<String> jDanhSachChat;
    private javax.swing.JTextPane jKhungHienThiChat;
    private javax.swing.JTextArea jKhungSoanNoiDungChat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHienThiNguoiChat;
    private javax.swing.JScrollPane jScrollKhungHienThi;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}
