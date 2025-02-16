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

    private Long user_id;

    // Constructors
    public Wishlist() {}

    public Wishlist(String name, LocalDate date, Long user_id) {
        this.name = name;
        this.date = date;
        this.user_id = user_id;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Long getUserId() { return user_id; }
    public void setUserId(Long user_id) { this.user_id = user_id; }
}
