package com.wishlist.demo.controller;

import com.wishlist.demo.model.Books;
import com.wishlist.demo.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    
    private final BooksRepository booksRepository;

    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @PostMapping
    public Books addBook(@RequestBody Books book) {
        return booksRepository.save(book);
    }
}
