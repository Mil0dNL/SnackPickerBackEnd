package com.snackpicker.main.controller;

import com.snackpicker.main.model.User;
import com.snackpicker.main.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping()
    public List<User> getAll()
    {
        try
        {
            return userService.getAllUsers();
        }
        catch(Exception e) {return null;}
    }

    @PostMapping
    public String create(@RequestBody User user)
    {
        try
        {
            userService.saveUser(user);
            return "Succesfully created user.";
        }
        catch(Exception e) { return "error creating user.";}
    }


}
