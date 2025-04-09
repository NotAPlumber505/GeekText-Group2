package com.BookInfo.BookInfo.Controller;


import com.BookInfo.BookInfo.Entity.Authors;
import com.BookInfo.BookInfo.Entity.Books;
import com.BookInfo.BookInfo.Repository.AuthorsRepo;
import com.BookInfo.BookInfo.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorsRepo authorsRepo;

    @PostMapping("/addBook")
    public Books postDetails(@RequestBody Books book) {
        // Fetch the author from the database by ID
        Authors author = authorsRepo.findById(book.getAuthor_id().getId()) // Assuming the book request sends an author ID
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author not found"));

        // Set the author in the book entity
        book.setAuthor_id(author);

        // Save the book with the linked author
        return booksService.saveDetails(book);
    }


    @GetMapping("/getBookByISBN/{isbn}")
    public Books fetchDetailsByISBN(@PathVariable Long isbn){
        return booksService.getBookDetailsByISBN(isbn);
    }

    @GetMapping("/getBooksByAuthorID/{author_id}")
    public List<Books> fetchDetailsByAuthorId(@PathVariable int author_id) {
        // Fetch the author by id
        Authors author = authorsRepo.findById(author_id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Call the service method to fetch books by this author
        return booksService.getBooksByAuthorId(author);
    }

}