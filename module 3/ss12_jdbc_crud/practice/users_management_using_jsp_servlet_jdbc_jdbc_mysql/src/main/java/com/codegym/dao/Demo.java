package com.codegym.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String updateUserSqlPro = "{call update_User(?,?,?,?)}";

        Connection connection = BaseRepository.getConnectDB();

        CallableStatement cs = connection.prepareCall(updateUserSqlPro);

        cs.setString(1, "ok");
        cs.setString(2, "akaliCute");
        cs.setString(3, "ok");
        cs.setInt(4, 8);

        cs.executeUpdate();
    }
}
