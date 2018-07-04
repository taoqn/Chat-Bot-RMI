/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBackup;

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

    public ResultSet viewData(String date, String server) { // Hàm lấy dữ liệu theo ngày tháng và tên Server
        ResultSet resultSet = null;
        try {
            Statement statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("select * from `backupserver` where timeBackup like '" + date + "%' and ServerBackup='" + server + "'");
        } catch (SQLException e) {
        }
        return resultSet;
    }

    public boolean Backup(String date, String data, String server) { // Hàm chèn dữ liệu vào bảng
        try {
            Statement statement = (Statement) connection.createStatement();
            if (statement.executeUpdate("INSERT INTO `chatgrouprmi`.`backupserver` VALUES (NULL , '" + date + "', '" + data + "', '" + server + "')") >= 1) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
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
