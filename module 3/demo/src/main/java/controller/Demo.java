package controller;

import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;

public class Demo {
    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aAa123aa";


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            conn.setAutoCommit(false);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            String sql =
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
