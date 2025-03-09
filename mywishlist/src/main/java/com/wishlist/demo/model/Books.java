package com.wishlist.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")  // Ensure this matches your database table name
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long wishlist_id;

    // Constructors, Getters, and Setters
    public Books() {}

    public Books(String title, Long wishlist_id) {
        this.title = title;
        this.wishlist_id = wishlist_id;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Long getWishlistId() { return wishlist_id; }
    public void setWishlistId(Long wishlist_id) { this.wishlist_id = wishlist_id; }
}
