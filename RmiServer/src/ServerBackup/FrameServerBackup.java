/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBackup;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

/**
 *
 * @author DinhTao
 */
public class FrameServerBackup extends javax.swing.JFrame {

    private ServerBackupImpl serverBackup;
    private Hashtable ht;

    public FrameServerBackup() throws RemoteException, AlreadyBoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        Registry r = LocateRegistry.createRegistry(4444);
        serverBackup = new ServerBackupImpl(this);
        r.bind("rmi://localhost/Backup", serverBackup);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinnerDay = new javax.swing.JSpinner();
        jSpinnerMonth = new javax.swing.JSpinner();
        jSpinnerYear = new javax.swing.JSpinner();
        jComboBoxServer = new javax.swing.JComboBox<>();
        jButtonXem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jKhungHienThi = new javax.swing.JTextArea();
        jComboBoxBackup = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Backup");

        jSpinnerDay.setModel(new javax.swing.SpinnerNumberModel(27, 1, 31, 1));
        jSpinnerDay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerDayStateChanged(evt);
            }
        });

        jSpinnerMonth.setModel(new javax.swing.SpinnerNumberModel(11, 1, 12, 1));
        jSpinnerMonth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMonthStateChanged(evt);
            }
        });

        jSpinnerYear.setModel(new javax.swing.SpinnerNumberModel(2016, 2010, 2100, 1));
        jSpinnerYear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerYearStateChanged(evt);
            }
        });

        jComboBoxServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server Trung Gian", "Server Hà Nội", "Server Đà Nẵng", "Server Hồ Chí Minh" }));

        jButtonXem.setText("Xem");
        jButtonXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemActionPerformed(evt);
            }
        });

        jKhungHienThi.setEditable(false);
        jKhungHienThi.setColumns(20);
        jKhungHienThi.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jKhungHienThi.setRows(5);
        jScrollPane1.setViewportView(jKhungHienThi);

        jComboBoxBackup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBackupItemStateChanged(evt);
            }
        });

        jLabel1.setText("Các Bảng Backup : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxServer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinnerDay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonXem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxBackup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 156, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonXem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinnerDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerDayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerDayStateChanged
        setDay();
    }//GEN-LAST:event_jSpinnerDayStateChanged

    private void jSpinnerMonthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMonthStateChanged
        setDay();
    }//GEN-LAST:event_jSpinnerMonthStateChanged

    private void jSpinnerYearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerYearStateChanged
        setDay();
    }//GEN-LAST:event_jSpinnerYearStateChanged

    private void jButtonXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemActionPerformed
        int y = Integer.parseInt(jSpinnerYear.getValue().toString());
        int m = Integer.parseInt(jSpinnerMonth.getValue().toString());
        int d = Integer.parseInt(jSpinnerDay.getValue().toString());
        String ngay = ""+d;
        String thang = ""+m;
        if (d < 10) {
            ngay = "0" + d;
        }
        if (m < 10) {
            thang = "0" + m;
        }  // Xử lý ngày tháng

        String nameServer = "Server";
        switch (jComboBoxServer.getSelectedIndex()) {
            case 0:
                nameServer = "Server";break;
            case 1:
                nameServer = "HaNoi";break;
            case 2:
                nameServer = "DaNang";break;
            case 3:
                nameServer = "HCM";break;
        } // Xử lý tên Server
        
        try {
            ht = serverBackup.getDataBackup(ngay + "/" + thang + "/" + y, nameServer);// Gọi lấy dữ liệu (trả về là Hashtable)
            jComboBoxBackup.removeAllItems();// Xóa các Item cũ
            if (!ht.isEmpty()) {
                Enumeration names = ht.keys();
                int i = 1;
                while (names.hasMoreElements()) {
                    String str = (String) names.nextElement();
                    jComboBoxBackup.addItem(str);
                    if (i == 1) {
                        jKhungHienThi.setText((String) ht.get(str));
                    }
                    i++;
                }
            } else {
                jKhungHienThi.setText("");
                JOptionPane.showMessageDialog(this, "Dữ liệu không tồn tại !");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrameServerBackup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonXemActionPerformed

    private void jComboBoxBackupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBackupItemStateChanged
        if(jComboBoxBackup.getItemCount()>0)
            jKhungHienThi.setText((String) ht.get(jComboBoxBackup.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxBackupItemStateChanged

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
            java.util.logging.Logger.getLogger(FrameServerBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameServerBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameServerBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameServerBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Tạo và hiển thị form Server Backup */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameServerBackup().setVisible(true);
                } catch (RemoteException | AlreadyBoundException ex) {
                    Logger.getLogger(FrameServerBackup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void setDay() { //Hàm đặt ngày
        int y = Integer.parseInt(jSpinnerYear.getValue().toString());
        int m = Integer.parseInt(jSpinnerMonth.getValue().toString());
        int d = Integer.parseInt(jSpinnerDay.getValue().toString());
        switch (m) {
            case 2:
                if (y % 4 == 0 && d > 29) {
                    jSpinnerDay.setValue(29);
                }
                if (y % 4 != 0 && d > 28) {
                    jSpinnerDay.setValue(28);
                }
                break;
            case 4:
                if (d > 30) {
                    jSpinnerDay.setValue(30);
                }
                break;
            case 6:
                if (d > 30) {
                    jSpinnerDay.setValue(30);
                }
                break;
            case 9:
                if (d > 30) {
                    jSpinnerDay.setValue(30);
                }
                break;
            case 11:
                if (d > 30) {
                    jSpinnerDay.setValue(30);
                }
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonXem;
    private javax.swing.JComboBox<String> jComboBoxBackup;
    private javax.swing.JComboBox<String> jComboBoxServer;
    private javax.swing.JTextArea jKhungHienThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerDay;
    private javax.swing.JSpinner jSpinnerMonth;
    private javax.swing.JSpinner jSpinnerYear;
    // End of variables declaration//GEN-END:variables
}
