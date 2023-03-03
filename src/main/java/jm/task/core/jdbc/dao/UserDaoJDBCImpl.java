//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import javax.lang.model.element.Name;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private void statementExecutor(String query) {
//        try (Statement string = Util.getConnection().createStatement()) {
//            string.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        statementExecutor("CREATE TABLE IF NOT EXISTS users " +
//                "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");
//    }
//
//    public void dropUsersTable() {
//
//        statementExecutor("DROP TABLE IF EXISTS users");
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try ( PreparedStatement str = Util.getConnection().prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
//            str.setString(1, name);
//            str.setString(2, lastName);
//            str.setByte(3, age);
//            str.executeUpdate();
//            System.out.println("User " + name + " добавлен");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try ( PreparedStatement svm = Util.getConnection().prepareStatement("DELETE FROM users WHERE id = ?")) {
//            svm.setLong(1, id);
//            svm.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        try ( ResultSet string = Util.getConnection().createStatement().executeQuery("SELECT * FROM users")) {
//            while (string.next()) {
//                User user = new User(string.getString("name"),
//                        string.getString("last_name"), string.getByte("age"));
//                user.setId(string.getLong("id"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        statementExecutor("TRUNCATE TABLE users");
//        }
//    }

