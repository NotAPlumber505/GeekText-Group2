package com.wishlist.demo.controller;

import com.wishlist.demo.model.Wishlist;
import com.wishlist.demo.model.Books;
import com.wishlist.demo.repository.WishlistRepository;
import com.wishlist.demo.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistRepository wishlistRepository;
    private final BooksRepository booksRepository;

    public WishlistController(WishlistRepository wishlistRepository, BooksRepository booksRepository) {
        this.wishlistRepository = wishlistRepository;
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // Get all wishlists for a user
    @GetMapping("/user/{userId}/books")
    public List<Map<String, Object>> getWishlistsBooksByUserId(@PathVariable Long userId) {
        List<Wishlist> wishlists = wishlistRepository.findByUserId(userId);

        return wishlists.stream().map(wishlist -> {
            List<Books> books = booksRepository.findByWishlistId(wishlist.getId());
            return Map.of(
                "id", wishlist.getId(),
                "name", wishlist.getName(),
                "books", books
            );
        }).collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
