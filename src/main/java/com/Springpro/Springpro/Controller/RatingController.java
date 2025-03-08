package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/api/books")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/add/ratings")
    public ResponseEntity<Rating> addRating(@RequestBody RatingRequest ratingRequest) {
        try {
            Rating rating = ratingService.addRating(
                    ratingRequest.getUserId(),
                    ratingRequest.getBookId(),
                    ratingRequest.getRating()
            );
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            System.out.println("Error en addRating: " + e.getMessage()); // Loguea el error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add/comment")
    public ResponseEntity<Rating> addComment(@RequestBody RatingRequest ratingRequest) {
        try {
            Rating rating = ratingService.addComment(ratingRequest.getUserId(), ratingRequest.getBookId(), ratingRequest.getComment());
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/comments/{bookId}")
    public ResponseEntity<List<Map<String, Object>>> getComments(@PathVariable int bookId) {
        try {
            List<Map<String, Object>> comments = ratingService.getCommentsByBookId(bookId);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{bookId}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable int bookId) {
        try {
            double average = ratingService.getAverageRatingByBookId(bookId);
            return ResponseEntity.ok(average);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    static class RatingRequest {
        private int userId;
        private int bookId;
        private double rating;
        private String comment;

        // Getters y setters
        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}