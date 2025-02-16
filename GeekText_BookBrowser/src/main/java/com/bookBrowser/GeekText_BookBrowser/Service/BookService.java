package com.bookBrowser.GeekText_BookBrowser.Service;


import com.bookBrowser.GeekText_BookBrowser.Entity.BookEntity;
import com.bookBrowser.GeekText_BookBrowser.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookEntity saveDetails(BookEntity bookEntity) {

        return bookRepo.save(bookEntity);

    }

    public BookEntity getBookDetailsByGenreID(int bookId) {

        return bookRepo.findById(bookId).orElse(null);

    }
}
