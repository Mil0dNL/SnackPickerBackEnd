package com.snackpicker.main.controller;

import com.snackpicker.main.model.User;
import com.snackpicker.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
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
        System.out.println("CreateReq");
        try
        {
            userService.saveUser(user);
            return "Successfully created user.";
        }
        catch(Exception e) {         e.printStackTrace();
            return "error creating user.";}
    }


}
