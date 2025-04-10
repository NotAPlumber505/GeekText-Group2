package com.bookBrowser.GeekTextBookBrowser.demo.Repository;

import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findByGenre(String genre);
    List<BookEntity> findTop10ByOrderBySaleQuantityDesc();
    List<BookEntity> findByRatingGreaterThanEqual(double rating);
    List<BookEntity> findByPublisher(String publisher);
}
