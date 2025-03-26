package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
    List<Rating> findByBook(Book book);
    List<Rating> findByStudent(Student student);
}

