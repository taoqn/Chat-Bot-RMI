/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Administrator
 */
public interface ClientInterFace extends Remote{
    public void sendMsgClient(ClientInterFace c, String x, boolean p) throws RemoteException;
    public void setList() throws RemoteException;
    public void setChatGroup(Object o) throws RemoteException;
    public void setLogin(String d, String N, String h, String ns, String s, String dchi) throws RemoteException;
    public void closeChat() throws RemoteException;
    public String getID() throws RemoteException;
    public String getNickName() throws RemoteException;
    public String getUserName() throws RemoteException;
    public String getPassWord() throws RemoteException;
    public String getHoTen() throws RemoteException;
    public String getNgaySinh() throws RemoteException;
    public String getSDT() throws RemoteException;
    public String getDiaChi() throws RemoteException;
}
