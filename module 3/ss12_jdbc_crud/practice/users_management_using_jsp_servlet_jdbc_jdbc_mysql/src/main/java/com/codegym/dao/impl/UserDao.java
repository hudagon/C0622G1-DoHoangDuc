package com.codegym.dao.impl;

import com.codegym.dao.BaseRepository;
import com.codegym.dao.IUserDao;
import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao implements IUserDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public UserDao() {
    }


    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Connection connection = BaseRepository.getConnectDB();
        // try-with-resource statement will auto close the connection.
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        Connection connection = BaseRepository.getConnectDB();
        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {


        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = BaseRepository.getConnectDB();
        try (

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        try (
                PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)
        ) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try (
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchUser(String country) throws SQLException {
        List<User> users = selectAllUsers();
        List<User> usersFounded = new ArrayList<>();

        for (User x : users) {
            if (x.getCountry().equals(country)) {
                usersFounded.add(x);
            }
        }

        return usersFounded;
    }

    @Override
    public List<User> sort(String sortOption) throws SQLException {
        List<User> users = selectAllUsers();

        Collections.sort(users);

        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String queryById = "{CALL get_user_by_id(?)}";

        Connection conn = BaseRepository.getConnectDB();



        try {
            CallableStatement cs = conn.prepareCall(queryById);

            cs.setInt(1, id);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);

            }

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String insertUserSql = "insert into users (name,email,country) values (?,?,?);";

        Connection connection = BaseRepository.getConnectDB();

        CallableStatement cs = connection.prepareCall(insertUserSql);

        cs.setString(1, user.getName());
        cs.setString(2, user.getEmail());
        cs.setString(3, user.getCountry());

        cs.executeUpdate();
    }

    @Override
    public List<User> selectAllUsersPro() {
        List<User> users = new ArrayList<>();
        String selectAllUsersSql = "{call select_all_users()}";

        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall(selectAllUsersSql);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String email = rs.getString("email");
                users.add(new User(id, name, country, email));
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return users;
    }

    @Override
    public void updateUserPro(User user) throws SQLException {
        String updateUserSqlPro = "{call update_user(?,?,?,?)}";

        Connection connection = BaseRepository.getConnectDB();

        CallableStatement cs = connection.prepareCall(updateUserSqlPro);

        cs.setString(1, user.getName());
        cs.setString(2, user.getEmail());
        cs.setString(3, user.getCountry());
        cs.setInt(4, user.getId());

        cs.executeUpdate();
    }

    @Override
    public void deleteUserPro(int id) {
        String deleteUserSqlPro = "{call delete_user(?)}";

        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall(deleteUserSqlPro);

            cs.setInt(1, id);

            cs.executeUpdate();

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
