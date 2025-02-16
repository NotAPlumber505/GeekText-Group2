package com.springpro.Springpro.Controller;

import com.springpro.Springpro.Entity.User;
import com.springpro.Springpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User postDetails(@RequestBody User user) {

        return userService.saveDetails(user);

    }

    @GetMapping("/getUser")
    public List<User> getDetails(){

        return userService.getAllDetails();

    }

    @GetMapping("/getUserByID/{id}")
    public User fetchDetailsById(@PathVariable int id) {

        return userService.getUserDetailsById(id);

    }
}
