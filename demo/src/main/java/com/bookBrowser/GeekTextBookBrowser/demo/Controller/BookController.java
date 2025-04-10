package com.bookBrowser.GeekTextBookBrowser.demo.Controller;

import com.bookBrowser.GeekTextBookBrowser.demo.Service.BookService;
import com.bookBrowser.GeekTextBookBrowser.demo.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getBookByGenre/{genre}")
    public List<BookEntity> fetchBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/topSellers")
    public List<BookEntity> fetchTopSellers() {
        return bookService.getTopSellingBooks();
    }

    @GetMapping("/getBookByRating/{rating}")
    public List<BookEntity> fetchBooksByRating(@PathVariable double rating) {
        return bookService.getBooksByRating(rating);
    }

    @PutMapping("/applyDiscount")
    public ResponseEntity<String> applyDiscount(@RequestParam double discountPercentage, @RequestParam String publisher) {

        // Call service to apply discount
        bookService.applyDiscountToPublisher(discountPercentage, publisher);

        // Return a success message
        return ResponseEntity.ok("Discount applied successfully to publisher: " + publisher);
    }

}
