package com.wishlist.demo.controller;

import com.wishlist.demo.model.Wishlist;
import com.wishlist.demo.model.Books;
import com.wishlist.demo.repository.WishlistRepository;
import com.wishlist.demo.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistRepository wishlistRepository;
    private final BooksRepository booksRepository;

    public WishlistController(WishlistRepository wishlistRepository, BooksRepository booksRepository) {
        this.wishlistRepository = wishlistRepository;
        this.booksRepository = booksRepository;
    }

    @Transactional
    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        if (wishlist.getBooks() != null) {
            Set<Books> books = wishlist.getBooks().stream()
                .map(book -> booksRepository.findById(book.getId()).orElse(null))
                .filter(book -> book != null)
                .collect(Collectors.toSet());
            wishlist.setBooks(books);
        }
        return wishlistRepository.save(wishlist);
    }

    @Transactional
    @GetMapping("/user/{userId}/books")
    public List<Map<String, Object>> getWishlistsBooksByUserId(@PathVariable Long userId) {
        List<Wishlist> wishlists = wishlistRepository.findByUserId(userId);
    
        return wishlists.stream().map(wishlist -> Map.of(
            "id", wishlist.getId(),
            "name", wishlist.getName(),
            "books", wishlist.getBooks().stream().map(book -> Map.of(
                "id", book.getId(),
                "title", book.getTitle()
            )).collect(Collectors.toList()) // Convert books to a list of maps
        )).collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    @Transactional
    @PostMapping("/{wishlistId}/add-book/{bookId}")
    public ResponseEntity<String> addBookToWishlist(@PathVariable Long wishlistId, @PathVariable Long bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Books books = booksRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        wishlist.getBooks().add(books);
        wishlistRepository.save(wishlist);

        return ResponseEntity.ok("Book added to wishlist successfully");
    }
}