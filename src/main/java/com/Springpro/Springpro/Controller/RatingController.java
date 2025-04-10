package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // Add rating to a book
    @PostMapping("/add/ratings")
    public ResponseEntity<?> addRating(@RequestBody RatingRequest ratingRequest) {
        try {
            if (ratingRequest.getStudentId() <= 0 || ratingRequest.getBookId() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Student ID and Book ID need to be  valid values.");
            }

            Rating rating = ratingService.addRating(
                    ratingRequest.getStudentId(),
                    ratingRequest.getBookId(),
                    ratingRequest.getRating()
            );
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding rating: " + e.getMessage());
        }
    }

    // Add comment to a book
    @PostMapping("/add/comment")
    public ResponseEntity<?> addComment(@RequestBody RatingRequest ratingRequest) {
        try {
            if (ratingRequest.getStudentId() <= 0 || ratingRequest.getBookId() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Student ID and Book ID need to be valid values.");
            }
            if (ratingRequest.getComment() == null || ratingRequest.getComment().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("The comment can't be empty.");
            }

            Rating rating = ratingService.addComment(
                    ratingRequest.getStudentId(),
                    ratingRequest.getBookId(),
                    ratingRequest.getComment()
            );
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding comment: " + e.getMessage());
        }
    }

    // Gets comments by book
    @GetMapping("/comments/{bookId}")
    public ResponseEntity<?> getComments(@PathVariable int bookId) {
        try {
            List<Map<String, Object>> comments = ratingService.getCommentsByBookId(bookId);
            if (comments.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("There are not comments for this book.");
            }
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting comments: " + e.getMessage());
        }
    }

    // Get average rating for book
    @GetMapping("/{bookId}/average-rating")
    public ResponseEntity<?> getAverageRating(@PathVariable int bookId) {
        try {
            double average = ratingService.getAverageRatingByBookId(bookId);
            return ResponseEntity.ok(Map.of("bookId", bookId, "averageRating", average));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting average rating: " + e.getMessage());
        }
    }

    // Internal class to get request of rating and comments
    static class RatingRequest {
        private int studentId;
        private int bookId;
        private double rating;
        private String comment;

        // Getters y Setters
        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
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
