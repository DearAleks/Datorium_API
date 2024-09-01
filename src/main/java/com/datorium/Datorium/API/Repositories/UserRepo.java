package com.datorium.Datorium.API.Repositories;

import com.datorium.Datorium.API.DTOs.User;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();

    public int add(User user) {
        users.add(user);
        return users.size();
    }
    public ArrayList<User> get() {
        return users;
    }

    public User get(int id) {
        return users.get(id);
    }
    public User update(int userIndex, User updateUserDTO) { // usually using DTO User to update real users in the DB
        var user = users.get(userIndex);
        user.name = updateUserDTO.name;
        return user;
    }

}
