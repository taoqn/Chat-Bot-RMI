/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;

/**
 *
 * @author Administrator
 */
public interface ServerBackupInterface extends Remote {
    public boolean BackupData(String time, String data, String server) throws RemoteException;
    public Hashtable getDataBackup(String date, String server) throws RemoteException;
}
