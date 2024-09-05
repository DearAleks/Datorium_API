// a service class that handles user-related business logic

package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Repositories.UserRepo;
import org.apache.coyote.BadRequestException;

import java.util.ArrayList;

public class UserService {
    private UserRepo userRepo; // UserService, called by UserController is creating a new repository
    public UserService() {
        userRepo = new UserRepo(); // connecting UserService and UserRepo, because we want to be able to connect to the database. Every other Service is going to have it's own repo with it's own connection to a DB (encapsulation)
    }
    public void add(User user) throws BadRequestException {
        if(user.name.isEmpty()){
            throw new BadRequestException("Name cannot be empty");
        }
        userRepo.add(user);
    }

    public ArrayList<User> get() {
        return userRepo.get();
    }
    public User update(int userIndex, User updateUserDTO) {
        return userRepo.update(userIndex, updateUserDTO);
    }
}
