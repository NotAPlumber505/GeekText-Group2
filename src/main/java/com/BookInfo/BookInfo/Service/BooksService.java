package com.BookInfo.BookInfo.Service;

import com.BookInfo.BookInfo.Entity.Authors;
import com.BookInfo.BookInfo.Entity.Books;
import com.BookInfo.BookInfo.Repository.AuthorsRepo;
import com.BookInfo.BookInfo.Repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private AuthorsRepo authorsRepo;

    public Books saveDetails(Books books){
        return booksRepo.save(books);
    }

    public Books getBookDetailsByISBN(Long isbn){
        return booksRepo.findByIsbn(isbn); // Use the correct method that accepts Long
    }

    public List<Books> getBooksByAuthorId(Authors author){
        return booksRepo.findByAuthor(author);
    }

}
