package com.geektext.repository;

import com.geektext.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
