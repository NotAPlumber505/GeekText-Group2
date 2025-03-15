package com.BookInfo.BookInfo.Controller;


import com.BookInfo.BookInfo.Entity.Books;
import com.BookInfo.BookInfo.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/addBook")
    public Books postDetails(@RequestBody Books book)
    {
        return booksService.saveDetails(book);
    }

    @GetMapping("/getBookByISBN/{isbn}")
    public Books fetchDetailsByISBN(@PathVariable int isbn){
        return booksService.getBookDetailsByISBN(isbn);
    }
}