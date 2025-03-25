package com.springpro.Springpro.Service;

import com.springpro.Springpro.Entity.User;
import com.springpro.Springpro.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveDetails(User user) {

        return userRepo.save(user);

    }

    public List<User> getAllDetails(){

        return userRepo.findAll();

    }

    public User getUserDetailsById(int id) {

        return userRepo.findById(id).orElse(null);

    }

}
