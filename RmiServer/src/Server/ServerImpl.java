/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.FrameServer;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;
import rmiserver.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInterFace {

    private FrameServer fs;
    private Vector v = new Vector();
    private MySQL sql;
    private int dem = 1;

    public ServerImpl(FrameServer f) throws RemoteException, ClassNotFoundException, SQLException {
        sql = new MySQL();
        fs = f;
    }

    @Override // Hàm Đăng ký 1 client vào Server. Nếu thành công trả về True, còn không trả về False
    public boolean addAccountServer(ClientInterFace c) throws RemoteException {
        if (sql.viewRegistry(c.getUserName(), c.getPassWord(), c.getNickName(), c.getHoTen(), c.getNgaySinh(), c.getSDT(), c.getDiaChi())) {
            sendByServer("[User: " + c.getUserName() + " ] tạo tài khoản thành công !");
            return true;
        }
        return false;
    }

    @Override // Hàm Login 1 client vào Server. Nếu thành công trả về True, còn không trả về False
    public boolean loginAccountServer(ClientInterFace c) throws RemoteException {
        if (!checkAccount(c)) {
            ResultSet rs = sql.viewLogin(c.getUserName(), c.getPassWord());
            try {
                if (rs.next()) {
                    v.add(c);
                    byte[] utf8Bytes = rs.getString(4).getBytes("Cp1252");
                    String nick = new String(utf8Bytes, "UTF16");
                    utf8Bytes = rs.getString(5).getBytes("Cp1252");
                    String hoten = new String(utf8Bytes, "UTF16");
                    utf8Bytes = rs.getString(8).getBytes("Cp1252");
                    String diachi = new String(utf8Bytes, "UTF16");
                    c.setLogin(rs.getString(1), nick, hoten, rs.getString(6), rs.getString(7), diachi);
                    sendByServer("[ID: " + rs.getString(1) + " ] ĐÃ ĐĂNG NHẬP VÀO HỆ THỐNG !\n"
                            + "NickName : " + nick + "\n"
                            + "HoTen : " + hoten + "\t|Ngày Sinh :" + rs.getString(6));
                    return true;
                }
            } catch (SQLException | UnsupportedEncodingException ex) {
                Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override // Hàm gửi nôi dung trong khung hiển thị
    public void sendByServer(String x) throws RemoteException {
        Date date = new Date(System.currentTimeMillis());
        fs.sendMsg(dem + ". [" + date.toLocaleString() + "] -- " + x);
        fs.sendMsg("--------------------------------------------");
        dem++;
    }

    @Override // Hàm trả về một mản các Client đang hoạt động trên Server
    public Vector getClientByServer() throws RemoteException {
        return v;
    }

    @Override // Hàm thoát client ra khỏi Server
    public void disAccountServer(ClientInterFace c) throws RemoteException {
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            ClientInterFace c1 = (ClientInterFace) e.nextElement();
            if (c1.getID().equals(c.getID())) {
                sendByServer("[ID: " + c.getID() + " ] ĐÃ ĐĂNG XUẤT KHỎI HỆ THỐNG !\n"
                        + "NickName : " + c.getNickName() + "\n"
                        + "HoTen : " + c.getHoTen() + "\t|Ngày Sinh :" + c.getNgaySinh());
                v.remove(c);
            }
        }
    }

    @Override // Hàm kiểm tra client đã tồn tại trên server chưa
    public boolean checkAccount(ClientInterFace c) throws RemoteException {
        if (!v.isEmpty()) {
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                ClientInterFace c1 = (ClientInterFace) e.nextElement();
                if (c1.getUserName().equals(c.getUserName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
