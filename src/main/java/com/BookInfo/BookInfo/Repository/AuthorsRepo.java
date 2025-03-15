package com.BookInfo.BookInfo.Repository;

import com.BookInfo.BookInfo.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepo extends JpaRepository<Authors, Integer> {

}