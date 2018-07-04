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
public interface SubServerInterface extends Remote{
    public void sendSubServer(String x) throws RemoteException;
    public Vector getClientSubServer() throws RemoteException;
    public ClientInterFace getClientSubServer(int i) throws RemoteException;
    public void loginClientSubServer(ClientInterFace c) throws RemoteException;
    public boolean getStatusSubServer() throws RemoteException;
    public void disClientSubServer(ClientInterFace c) throws RemoteException;
    public boolean addClientSubServer(ClientInterFace c) throws RemoteException;
    public String getNameSubServer() throws RemoteException;
    public void addClientCloseSubServer(String id) throws RemoteException;
    public void disClientCloseSubServer(String id) throws RemoteException;
    public boolean checkTime(String time) throws RemoteException;
}
