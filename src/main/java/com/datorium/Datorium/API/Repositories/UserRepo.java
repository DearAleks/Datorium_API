package com.datorium.Datorium.API.Repositories;

import com.datorium.Datorium.API.DTOs.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>(); // Mocked DB
    private String url = "jdbc:sqlite:my.db";

    public void add(User user){
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
        return users;
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
