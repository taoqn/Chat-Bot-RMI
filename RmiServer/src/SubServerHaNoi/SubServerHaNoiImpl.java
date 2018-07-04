package SubServerHaNoi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiserver.*;

/**
 *
 * @author Administrator
 */
public class SubServerHaNoiImpl extends UnicastRemoteObject implements SubServerInterface {

    private Vector v;
    private Vector closeC;
    private FrameSubServerHaNoi fs;
    private int dem = 1;

    public SubServerHaNoiImpl(FrameSubServerHaNoi f) throws RemoteException { // Hàm khởi tạo
        v = new Vector();
        closeC = new Vector();
        fs = f;
    }

    @Override
    public void sendSubServer(String x) throws RemoteException { // Hàm gửi nội dung lên khung hiển thị
        Date date = new Date(System.currentTimeMillis());
        fs.send(dem + ". [" + date.toLocaleString() + "] -- " + x);
        fs.send("--------------------------------------------");
        dem++;
    }

    @Override
    public Vector getClientSubServer() throws RemoteException { // Hàm trả về danh sách các Client
        return v;
    }

    @Override
    public void loginClientSubServer(ClientInterFace c) throws RemoteException { // Hàm Đăng Nhập
        v.add(c);
        sendSubServer("[ID: " + c.getID() + " ] ĐÃ KẾT NỐI !\n"
                + "NickName : " + c.getNickName() + "\n"
                + "HoTen : " + c.getHoTen() + "\t|Ngày Sinh :" + c.getNgaySinh());
        fs.updateList(v);
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            ClientInterFace c2 = (ClientInterFace) e.nextElement();
            if (c.getID().equals(c2.getID())) {

            } else {
                c2.setList();
            }
        }
    }

    @Override
    public boolean getStatusSubServer() throws RemoteException { // Hàm trả về trạng thái Sub Server (Số lượng là 20 Client)
        return v.size() < 20;
    }

    @Override
    public void disClientSubServer(ClientInterFace c) throws RemoteException {
        if (v.contains(c)) {
            v.remove(c);
            sendSubServer("[ID: " + c.getID() + " ] ĐÃ NGẮT KẾT NỐI !\n"
                    + "NickName : " + c.getNickName() + "\n"
                    + "HoTen : " + c.getHoTen() + "\t|Ngày Sinh :" + c.getNgaySinh());
            fs.updateList(v);
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                ClientInterFace c2 = (ClientInterFace) e.nextElement();
                if (c2.getID().equals(c.getID())) {

                } else {
                    c2.setList();
                }
            }
        }
    }

    @Override
    public boolean addClientSubServer(ClientInterFace c) throws RemoteException {// Hàm Đăng Nhập
        if (!v.contains(c)) {
            Enumeration e = closeC.elements();
            while (e.hasMoreElements()) {
                String c1 = (String) e.nextElement();
                String[] time = c1.split("-");
                if (time[0].equals(c.getID())) {
                    if (checkTime(time[1])) {
                        loginClientSubServer(c);
                        disClientCloseSubServer(time[0]);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            loginClientSubServer(c);
            return true;
        }
        return false;
    }

    @Override
    public String getNameSubServer() throws RemoteException { // Hàm trả về tên SubServer
        return "HaNoi";
    }

    @Override
    public ClientInterFace getClientSubServer(int i) throws RemoteException { // Hàm trả vê một Client theo vị trí trong mảng Vector
        if (i == -1) {
            return null;
        }
        return (ClientInterFace) v.get(i);
    }

    @Override
    public void addClientCloseSubServer(String id) throws RemoteException {// Hàm thêm id vào danh sách Phạt
        if (!closeC.contains(id)) {
            closeC.add(id);
        }
    }

    @Override
    public void disClientCloseSubServer(String id) throws RemoteException {// Hàm xóa id vào danh sách Phạt
        if (closeC.contains(id)) {
            closeC.remove(id);
        }
    }

    @Override
    public boolean checkTime(String time) throws RemoteException { // Hàm kiểm tra thời gian
        SimpleDateFormat formatterDay = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String strartDay = time;
        try {
            java.util.Date strart = formatterDay.parse(strartDay);
            java.util.Date end = new java.util.Date(System.currentTimeMillis());
            long diff = end.getTime() - strart.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if (diffDays > 0) {
                return true;
            }
            if (diffHours > 0) {
                return true;
            }
            if (diffMinutes >= 5) {
                return true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(SubServerHaNoiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
