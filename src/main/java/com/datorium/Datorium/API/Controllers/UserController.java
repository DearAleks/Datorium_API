package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.UpdateUserDTO;
import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // tells Spring that this class will handle HTTP requests and send responses back, usually in JSON format.
@RequestMapping("/user") // every endpoint inside this controller will have user prefix

public class UserController { //This line defines the UserController class, which is a controller for handling user-related operations (CRUD) in the application.

    private UserService userService; //a private field userService of type UserService is declared. This field will be used to interact with the user service layer, which handles the business logic.

    public UserController() { // a constructor, this runs first when creating UserController object
        // every UserController has it's own UserService, which has it's own UserRepo.
        userService = new UserService(); // Inside the constructor, a new instance of UserService is created and assigned to the userService field.
        // This means whenever a UserController object is created, it will automatically have a UserService instance to use.
    }

    @PostMapping("/add") // localhost:8800/add -> localhost:8800/user/add
    public int add(@RequestBody User user) { //@RequestBody tells Spring to take the JSON body of the incoming request and convert it into a User object.
        return userService.add(user); //userController is requesting data from userService
    }
    @GetMapping("/get")
    public ArrayList<User> get() {
        return userService.get();
    }
    @PostMapping("/update")
    public User update(@RequestBody UpdateUserDTO updateUserDTO) {
        return userService.update(updateUserDTO.userIndex, updateUserDTO.user);
    }
}
