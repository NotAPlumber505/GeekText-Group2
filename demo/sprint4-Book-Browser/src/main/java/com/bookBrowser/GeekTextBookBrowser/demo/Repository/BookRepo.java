package com.bookBrowser.GeekTextBookBrowser.demo.Repository;

import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findByGenreId(int genreId);
    List<BookEntity> findTop10ByOrderBySaleQuantityDesc();
    List<BookEntity> findByRatingGreaterThanEqual(double rating);
    List<BookEntity> findByPublisher(String publisher);
}
