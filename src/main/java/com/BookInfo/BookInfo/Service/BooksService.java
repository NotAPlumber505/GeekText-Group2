package com.BookInfo.BookInfo.Service;

import com.BookInfo.BookInfo.Entity.Books;
import com.BookInfo.BookInfo.Repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksRepo booksRepo;

    public Books saveDetails(Books books){
        return booksRepo.save(books);
    }

    public Books getBookDetailsByISBN(Long isbn){
        return booksRepo.findByIsbn(isbn); // Use the correct method that accepts Long
    }

}
