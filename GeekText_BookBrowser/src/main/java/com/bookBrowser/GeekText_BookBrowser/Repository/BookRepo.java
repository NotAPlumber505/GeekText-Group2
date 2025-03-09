package com.bookBrowser.GeekText_BookBrowser.Repository;

import com.bookBrowser.GeekText_BookBrowser.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByGenreId(int genreId);
    List<BookEntity> findTop10ByOrderBySaleQuantityDesc();
}

