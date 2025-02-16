package com.bookBrowser.GeekText_BookBrowser.Controller;

import com.bookBrowser.GeekText_BookBrowser.Service.BookService;
import com.bookBrowser.GeekText_BookBrowser.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public BookEntity postDetails(@RequestBody BookEntity bookEntity)
    {

        return bookService.saveDetails(bookEntity);

    }

    @GetMapping("/getBookByID/{bookId}")
    public BookEntity fetchDetailsById(@PathVariable int bookId) {

        return bookService.getBookDetailsByGenreID(bookId);

    }


}
