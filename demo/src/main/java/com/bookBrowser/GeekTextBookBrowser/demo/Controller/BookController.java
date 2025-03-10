package com.bookBrowser.GeekTextBookBrowser.demo.Controller;

import com.bookBrowser.GeekTextBookBrowser.demo.Service.BookService;
import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public BookEntity postDetails(@RequestBody BookEntity bookEntity) {

        return bookService.saveDetails(bookEntity);

    }

    @GetMapping("/getBookById/{bookId}")
    public BookEntity fetchDetailsById(@PathVariable int bookId) {

        return bookService.getBookDetailsById(bookId);

    }

    @GetMapping("/getBookByGenre/{genreId}")
    public List<BookEntity> fetchBooksByGenre(@PathVariable int genreId) {
        return bookService.getBooksByGenre(genreId);
    }

    @GetMapping("/topSellers")
    public List<BookEntity> fetchTopSellers() {

        return bookService.getTopSellingBooks();

    }

}
