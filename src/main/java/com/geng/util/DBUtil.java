package com.geng.util;

import com.mysql.cj.protocol.ResultsetRow;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/student_gui";
    private static final String DEIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PWD = "geng";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            return DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void closeConn(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void closePs(PreparedStatement preparedStatement){
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void closeRs(ResultSet resultset){
        if (resultset!=null){
            try {
                resultset.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new  DBUtil();
    }
}
