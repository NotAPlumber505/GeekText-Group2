package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Repository.RatingRepo;
import com.Springpro.Springpro.Repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private StudentRepo bookRepo;  // Renombrado para mayor claridad en el código

    public Rating saveDetails(Rating rating) {
        if (rating.getBook() == null || rating.getBook().getId() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book ID is missing in the request.");
        }

        // Fetch the book from the database
        Student book = bookRepo.findById(rating.getBook().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Book with ID " + rating.getBook().getId() + " not found."));

        rating.setBook(book);
        return ratingRepo.save(rating);
    }

    public Rating getDetailsByID(int id) {
        return ratingRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Rating with ID " + id + " not found."));
    }
}

