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

    // Agregar calificación
    public Rating addRating(int studentId, int bookId, double ratingValue) {
        if (ratingValue < 0 || ratingValue > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating must be between 0 and 5.");
        }

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found."));

        Rating rating = new Rating();
        rating.setRating(ratingValue);
        rating.setBook(book);
        rating.setStudent(student); // Asigna el estudiante

        return ratingRepo.save(rating);
    }

    // Agregar comentario
    public Rating addComment(int studentId, int bookId, String comment) {
        if (comment == null || comment.isEmpty() || comment.length() > 500) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment must be between 1 and 500 characters.");
        }

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found."));

        Rating rating = new Rating();
        rating.setComment(comment);
        rating.setBook(book);
        rating.setStudent(student); // Se asigna correctamente el estudiante

        return ratingRepo.save(rating);
    }

    // Obtener comentarios por libro
    public List<Map<String, Object>> getCommentsByBookId(int bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        List<Rating> ratings = ratingRepo.findByBook(book);
        return ratings.stream()
                .map(rating -> {
                    Map<String, Object> commentMap = new HashMap<>();
                    commentMap.put("studentName", rating.getStudent().getName()); // Ahora usamos student
                    commentMap.put("comment", rating.getComment());
                    return commentMap;
                })
                .collect(Collectors.toList());
    }

    // Obtener promedio de calificaciones de un libro
    public double getAverageRatingByBookId(int bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found."));

        List<Rating> ratings = ratingRepo.findByBook(book);
        return ratings.stream()
                .filter(r -> r.getRating() != null)
                .mapToDouble(Rating::getRating)
                .average()
                .orElse(0.0);
    }
}

