package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
