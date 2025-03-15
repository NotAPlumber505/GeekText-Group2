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

    // Agregar calificación
    @PostMapping("/add/ratings")
    public ResponseEntity<?> addRating(@RequestBody RatingRequest ratingRequest) {
        try {
            if (ratingRequest.getStudentId() <= 0 || ratingRequest.getBookId() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Student ID y Book ID deben ser valores válidos.");
            }

            Rating rating = ratingService.addRating(
                    ratingRequest.getStudentId(),
                    ratingRequest.getBookId(),
                    ratingRequest.getRating()
            );
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar calificación: " + e.getMessage());
        }
    }

    // Agregar comentario
    @PostMapping("/add/comment")
    public ResponseEntity<?> addComment(@RequestBody RatingRequest ratingRequest) {
        try {
            if (ratingRequest.getStudentId() <= 0 || ratingRequest.getBookId() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Student ID y Book ID deben ser valores válidos.");
            }
            if (ratingRequest.getComment() == null || ratingRequest.getComment().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El comentario no puede estar vacío.");
            }

            Rating rating = ratingService.addComment(
                    ratingRequest.getStudentId(),
                    ratingRequest.getBookId(),
                    ratingRequest.getComment()
            );
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar comentario: " + e.getMessage());
        }
    }

    // Obtener comentarios por libro
    @GetMapping("/comments/{bookId}")
    public ResponseEntity<?> getComments(@PathVariable int bookId) {
        try {
            List<Map<String, Object>> comments = ratingService.getCommentsByBookId(bookId);
            if (comments.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hay comentarios para este libro.");
            }
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener comentarios: " + e.getMessage());
        }
    }

    // Obtener promedio de calificación por libro
    @GetMapping("/{bookId}/average-rating")
    public ResponseEntity<?> getAverageRating(@PathVariable int bookId) {
        try {
            double average = ratingService.getAverageRatingByBookId(bookId);
            return ResponseEntity.ok(Map.of("bookId", bookId, "averageRating", average));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el promedio de calificación: " + e.getMessage());
        }
    }

    // Clase interna para recibir solicitudes de calificación y comentarios
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
