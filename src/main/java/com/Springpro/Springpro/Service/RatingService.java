package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Entity.Book;
import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Repository.RatingRepo;
import com.Springpro.Springpro.Repository.BookRepo;
import com.Springpro.Springpro.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private StudentRepo studentRepo;

    public Rating addRating(int userId, int bookId, double ratingValue) {
        if (ratingValue < 0 || ratingValue > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating must be between 0 and 5.");
        }

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        Student student = studentRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found."));

        Rating rating = new Rating();
        rating.setUserId(userId);
        rating.setRating(ratingValue);
        rating.setBook(book);
        rating.setStudent(student); // Asigna el estudiante

        return ratingRepo.save(rating);
    }

    public Rating addComment(int userId, int bookId, String comment) {
        if (comment == null || comment.isEmpty() || comment.length() > 500) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment must be between 1 and 500 characters.");
        }

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        Rating rating = new Rating();
        rating.setUserId(userId);
        rating.setComment(comment);
        rating.setBook(book);

        return ratingRepo.save(rating);
    }

    public List<Map<String, Object>> getCommentsByBookId(int bookId) {
        List<Rating> ratings = ratingRepo.findByBookId(bookId);
        return ratings.stream()
                .map(rating -> {
                    Map<String, Object> commentMap = new HashMap<>();
                    commentMap.put("userId", rating.getUserId());
                    commentMap.put("comment", rating.getComment());
                    return commentMap;
                })
                .collect(Collectors.toList());
    }

    public double getAverageRatingByBookId(int bookId) {
        List<Rating> ratings = ratingRepo.findByBookId(bookId);
        return ratings.stream()
                .filter(r -> r.getRating() != null)
                .mapToDouble(Rating::getRating)
                .average()
                .orElse(0.0);
    }


}
