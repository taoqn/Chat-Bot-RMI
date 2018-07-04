
package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import rmiserver.*;

/**
 *
 * @author Administrator
 */
public class ClientImpl extends UnicastRemoteObject implements ClientInterFace {

    FrameChatGroup fcg;
    private String ID;
    private String NickName;
    private String UserName;
    private String PassWord;
    private String HoTen;
    private String NgaySinh;
    private String SDT;
    private String DiaChi;

    public ClientImpl(String u, String p, String n, String h, String ns, String s, String d) throws RemoteException {
        UserName = u; PassWord = p;
        if (n != null && h != null && ns != null && s != null && d != null) {
            NickName = n;HoTen = h;NgaySinh = ns;SDT = s;DiaChi = d;
        }
    }
    @Override
    public void sendMsgClient(ClientInterFace c, String x, boolean p) throws RemoteException {
        try {
            fcg.sendGroup(c, x, p);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getID() throws RemoteException {
        return ID;
    }
    @Override
    public String getNickName() throws RemoteException {
        return NickName;
    }
    @Override
    public String getUserName() throws RemoteException {
        return UserName;
    }
    @Override
    public String getPassWord() throws RemoteException {
        return PassWord;
    }
    @Override
    public void setLogin(String d, String N, String h, String ns, String s, String dchi) throws RemoteException {
        this.ID = d;this.NickName = N;this.HoTen = h;this.NgaySinh = ns;this.SDT = s;this.DiaChi = dchi;
    }
    @Override
    public void setList() throws RemoteException {
        fcg.updateList(fcg.mc3o.subServer.getClientSubServer());
    }
    @Override
    public void setChatGroup(Object o) throws RemoteException {
        fcg = (FrameChatGroup) o;
    }
    @Override
    public void closeChat() throws RemoteException {
        fcg.closeGroupChat();
    }
    @Override
    public String getHoTen() throws RemoteException {
        return HoTen;
    }
    @Override
    public String getNgaySinh() throws RemoteException {
        return NgaySinh;
    }
    @Override
    public String getSDT() throws RemoteException {
        return SDT;
    }
    @Override
    public String getDiaChi() throws RemoteException {
        return DiaChi;
    }
}
