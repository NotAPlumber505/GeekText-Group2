package com.wishlist.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "wishlist_id")
    private Long wishlistId;

    // Constructors
    public Books() {}

    public Books(String title, Long wishlistId) {
        this.title = title;
        this.wishlistId = wishlistId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Long getWishlistId() { return wishlistId; }
    public void setWishlistId(Long wishlistId) { this.wishlistId = wishlistId; }
}
