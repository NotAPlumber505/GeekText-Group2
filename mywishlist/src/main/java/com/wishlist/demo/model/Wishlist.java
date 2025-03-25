package com.wishlist.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private LocalDate date;

    @Column(name = "user_id")
    private Long userId;

    @ManyToMany
    @JoinTable(
        name = "wishlist_books", 
        joinColumns = @JoinColumn(name = "wishlist_id"), 
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonIgnore
    private Set<Books> books = new HashSet<>();

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

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}