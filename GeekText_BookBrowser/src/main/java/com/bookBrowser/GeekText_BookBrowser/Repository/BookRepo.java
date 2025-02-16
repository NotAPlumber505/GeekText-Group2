package com.bookBrowser.GeekText_BookBrowser.Repository;

import com.bookBrowser.GeekText_BookBrowser.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {}
