package com.geektext.repository;

import com.geektext.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
