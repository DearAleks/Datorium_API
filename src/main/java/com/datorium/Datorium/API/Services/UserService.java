// a service class that handles user-related business logic

package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Repositories.UserRepo;

public class UserService {
    private UserRepo userRepo; // UserService, called by UserController is creating a new repository
    public UserService() {
        userRepo = new UserRepo(); // connecting UserService and UserRepo, because we want to be able to connect to the database. Every other Service is going to have it's own repo with it's own connection to a DB (encapsulation)
    }
    public int add(User user) {
        return userRepo.add(user);
    }
}
