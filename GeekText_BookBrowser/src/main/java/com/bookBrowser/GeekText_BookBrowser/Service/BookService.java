package com.bookBrowser.GeekText_BookBrowser.Service;


import com.bookBrowser.GeekText_BookBrowser.Entity.BookEntity;
import com.bookBrowser.GeekText_BookBrowser.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookEntity saveDetails(BookEntity bookEntity) {

        return bookRepo.save(bookEntity);

    }

    public BookEntity getBookDetailsById(int bookId) {

        return bookRepo.findById(bookId).orElse(null);

    }

    public List<BookEntity> getBooksByGenre(int genreId) {
        return bookRepo.findByGenreId(genreId);
    }

    public List<BookEntity> getTopSellingBooks() {
        return bookRepo.findTop10ByOrderBySaleQuantityDesc();
    }

}
