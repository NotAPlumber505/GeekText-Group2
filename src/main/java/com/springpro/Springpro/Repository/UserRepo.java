package com.springpro.Springpro.Repository;

import com.springpro.Springpro.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
