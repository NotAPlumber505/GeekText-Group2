package com.bookBrowser.GeekTextBookBrowser.demo.Repository;

import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findByGenreId(int genreId);
    List<BookEntity> findTop10ByOrderBySaleQuantityDesc();
    List<BookEntity> findBookByRating(int rating);

}
