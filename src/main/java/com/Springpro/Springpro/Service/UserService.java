package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.User;
import com.Springpro.Springpro.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Springpro.Springpro.Entity.CreditCard;
import com.Springpro.Springpro.Repository.CreditCardRepo;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CreditCardRepo creditCardRepo;

    public void saveDetails(User user) {

        userRepo.save(user);

    }

    public List<User> getAllDetails(){

        return userRepo.findAll();

    }

    public User getUserDetailsById(long id) {

        return userRepo.findById(id).orElse(null);

    }

    public void updateUserByUsername(String username, User updatedUser) {
        Optional<User> existingUserOpt = userRepo.findByUsername(username);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // Update fields only if provided (to prevent overwriting with null)
            if (updatedUser.getPassword() != null) existingUser.setPassword(updatedUser.getPassword());
            if (updatedUser.getFullName() != null) existingUser.setFullName(updatedUser.getFullName());
            if (updatedUser.getEmail() != null) existingUser.setEmail(updatedUser.getEmail());
            if (updatedUser.getAddress() != null) existingUser.setAddress(updatedUser.getAddress());

            userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }

        public void addCreditCardToUser(String username, CreditCard creditCard) {
            Optional<User> userOptional = userRepo.findByUsername(username);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                creditCard.setUser(user); // Associate the credit card with the user
                creditCardRepo.save(creditCard);
            } else {
                throw new RuntimeException("User not found with username: " + username);
            }
        }

}