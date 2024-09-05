// this class is responsible for the communication with the database
package com.datorium.Datorium.API.Repositories;

import com.datorium.Datorium.API.DTOs.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>(); // Mocked DB

    public void add(User user){
        String url = "jdbc:sqlite:my.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS people (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(20))");
                statement.execute("INSERT INTO people (name) VALUES ('" + user.name + "')");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<User> get() {
        String url = "jdbc:sqlite:my.db";
        var resultList = new ArrayList<User>();
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var statement = conn.createStatement();
                var result = statement.executeQuery("SELECT name FROM people"); //ResultSet data structure

                while (result.next()) { // loop stops when there is no next element
                    var user = new User();
                    user.name = result.getString("name");
                    resultList.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultList;
    }

//    public User get(int id) {
//        return users.get(id);
//    }
    public User update(int userIndex, User updateUserDTO) { // usually using DTO User to update real users in the DB
        var user = users.get(userIndex);
        user.name = updateUserDTO.name;
        return user;
    }

}
