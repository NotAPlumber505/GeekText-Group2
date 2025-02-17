package com.Springpro.Springpro.Service;
import com.Springpro.Springpro.Entity.Student;
import com.Springpro.Springpro.Repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student saveDetails(Student student){

        return studentRepo.save(student);

    }
    public Student getDetailsByID(int id){
        return studentRepo.findById(id).orElse(null);
    }
}
