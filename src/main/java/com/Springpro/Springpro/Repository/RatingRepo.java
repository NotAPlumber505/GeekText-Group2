package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
    List<Rating> findByBookId(int bookId);
    List<Rating> findByUserId(int userId);
}
