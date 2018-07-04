/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBackup;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiserver.*;

/**
 *
 * @author DinhTao
 */
public class ServerBackupImpl extends UnicastRemoteObject implements ServerBackupInterface {

    private MySQL sql;
    private FrameServerBackup fsb;

    public ServerBackupImpl(FrameServerBackup f) throws RemoteException {
        sql = new MySQL();
        fsb = f;
    }

    @Override
    public boolean BackupData(String time, String data, String server) throws RemoteException {
        return sql.Backup(time, data, server);
    }// Sao Lưu dữ liệu

    @Override
    public Hashtable getDataBackup(String date, String server) throws RemoteException {
        Hashtable ht = new Hashtable();
        ResultSet rs = sql.viewData(date, server);
        try {
            int i = 1;
            while (rs.next()) {
                byte[] utf8Bytes = rs.getString(3).getBytes("Cp1252");
                String data = new String(utf8Bytes, "UTF16");
                ht.put(i + ". Ngày: " + rs.getString(2).substring(0, 11) + " - Thời gian: " + rs.getString(2).substring(11), data);
                i++;
            }
        } catch (SQLException | UnsupportedEncodingException ex) {
            Logger.getLogger(ServerBackupImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ht;
    }// Hàm trả về dữ liệu
}
