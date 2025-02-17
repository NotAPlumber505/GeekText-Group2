package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
