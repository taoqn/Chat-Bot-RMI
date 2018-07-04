/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Statement;

public class MySQL {

    private Connection connection = null;

    public MySQL() { // Khởi tạo Kết nối tới MySQL
        String url = "jdbc:mysql://localhost:3306/chatgrouprmi?zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException  e) {
        }
    }

    public ResultSet viewLogin(String user, String pass) { // Hàm kiểm tra tài khoản khi đăng nhập
        ResultSet resultSet = null;
        try {
            Statement statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("select * from `taikhoan` where Username='" + user + "' and Password='" + pass + "'");
        } catch (SQLException e) {
        }
        return resultSet;
    }

    public boolean viewRegistry(String user, String pass, String nick, String hten, String nsinh, String sdt, String dchi) { // Hàm đăng ký tài khoản
        try {
            Statement statement = (Statement) connection.createStatement();
            if (statement.executeQuery("select * from `taikhoan` where Username='" + user + "' or NickName='" + nick + "' ").next()) {
                return false;
            } else {
                if (statement.executeUpdate("INSERT INTO `chatgrouprmi`.`taikhoan` VALUES (NULL , '" + user + "', '" + pass + "', '" + nick + "', '" + hten + "', '" + nsinh + "', '" + sdt + "', '" + dchi + "')") >= 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
        }
        return true;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            connection = null;
        } catch (SQLException e) {
        }
    }
}
