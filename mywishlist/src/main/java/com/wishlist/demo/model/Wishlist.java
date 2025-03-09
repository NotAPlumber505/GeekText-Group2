package com.wishlist.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private LocalDate date;

    @Column(name = "user_id")  // Maps it correctly to the database
    private Long userId;

    // Constructors
    public Wishlist() {}

    public Wishlist(String name, LocalDate date, Long userId) {
        this.name = name;
        this.date = date;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
