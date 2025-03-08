package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
