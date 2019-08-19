package com.qf.java1906.zhouzhihao.addressList.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
