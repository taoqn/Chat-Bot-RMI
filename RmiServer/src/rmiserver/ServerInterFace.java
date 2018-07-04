/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public interface ServerInterFace extends Remote {
    public boolean loginAccountServer(ClientInterFace c) throws RemoteException;
    public void sendByServer(String x) throws RemoteException;
    public Vector getClientByServer() throws RemoteException;
    public boolean addAccountServer(ClientInterFace c) throws RemoteException;
    public void disAccountServer(ClientInterFace c) throws RemoteException;
    public boolean checkAccount(ClientInterFace c) throws RemoteException;
}
