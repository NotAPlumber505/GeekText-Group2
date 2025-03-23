package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.User;
import com.Springpro.Springpro.Entity.CreditCard;
import com.Springpro.Springpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<Void> postDetails(@RequestBody User user) {

        userService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();  // HTTP status 201 Created

    }

    @GetMapping("/getUser")
    public List<User> getDetails(){

        return userService.getAllDetails();

    }

    @GetMapping("/getUserByID/{id}")
    public User fetchDetailsById(@PathVariable long id) {

        return userService.getUserDetailsById(id);

    }

    @PatchMapping("/updateUser/{username}")
    public ResponseEntity<Void> updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUserByUsername(username, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // HTTP status 204 No Content
    }


    @PostMapping("/addCreditCard/{username}")
    public ResponseEntity<Void> addCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        userService.addCreditCardToUser(username, creditCard);
        return ResponseEntity.status(HttpStatus.CREATED).build();  // HTTP status 201 Created
    }

}
