package com.BookInfo.BookInfo.Repository;

import com.BookInfo.BookInfo.Entity.Authors;
import com.BookInfo.BookInfo.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BooksRepo extends JpaRepository<Books, Integer> {
    Books findByIsbn(Long isbn);

    @Query("SELECT b FROM Books b WHERE b.author_id = :author")
    List<Books> findByAuthor(@Param("author") Authors author);
}
