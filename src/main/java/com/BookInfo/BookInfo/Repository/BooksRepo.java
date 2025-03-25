package com.BookInfo.BookInfo.Repository;

import com.BookInfo.BookInfo.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Books, Integer> {
    Books findByIsbn(Long isbn);
}
