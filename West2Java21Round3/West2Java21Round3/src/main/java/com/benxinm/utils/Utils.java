package com.benxinm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Utils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    private static String sql;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\JavaProject\\West2Java21Round3\\West2Java21Round3\\src\\main\\resources\\access.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet set,Statement statement,Connection connection){
        try {
            if (set!=null){
                set.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
