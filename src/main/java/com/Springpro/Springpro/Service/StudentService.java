package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Entity.Rating;
import com.Springpro.Springpro.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
/*
    public Student saveDetails(Student student) {
        return studentRepo.save(student);
    }

    public Student getDetailsById(int id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            double averageRating = calculateAverageRating(student);
            student.setAverageRating(averageRating);  // Setting the average rating
            return student;
        } else {
            return null;  // Return null if student is not found
        }
    }

    private double calculateAverageRating(Student student) {
        if (student.getRatings() == null || student.getRatings().isEmpty()) {
            return 0.0;  // Return 0 if no ratings exist
        }

        int sum = 0;
        for (Rating rating : student.getRatings()) {
            sum += rating.getRating();  // ✅ Accessing getRating() from Rating entity
        }

        return (double) sum / student.getRatings().size();
    }

 */
}



