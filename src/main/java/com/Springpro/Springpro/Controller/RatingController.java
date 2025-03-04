package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public Rating postDetails(@RequestBody Map<String, Object> payload) {
        // Crear un objeto Rating desde el payload
        Rating rating = new Rating();
        rating.setRating(Integer.parseInt(payload.get("rating").toString()));
        rating.setComment((String) payload.get("comment"));

        if (payload.containsKey("user_id")) {
            rating.setUserId(Integer.parseInt(payload.get("user_id").toString()));
        }

        // Crear un objeto Student (libro) para asociarlo
        Student book = new Student();
        book.setId(Integer.parseInt(payload.get("book_id").toString()));
        rating.setBook(book);

        return ratingService.saveDetails(rating);
    }

    @GetMapping("/getRating/{id}")
    public Rating fetchDetailsById(@PathVariable int id) {
        return ratingService.getDetailsByID(id);
    }
}