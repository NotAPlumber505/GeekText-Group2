package com.BookInfo.BookInfo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Books {
/*
    id INT auto_increment,
    ISBN bigint NOT NULL unique,
    book_name varchar(30),
    author varchar(30),
    author_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    book_description text,
    price decimal(3,2),
    genre varchar(30),
    publisher varchar(30),
    publish_year bigint,
    sold_copies bigint
*/
    //All the variables
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "ISBN", nullable = false, unique = true)
    private int isbn;

    @Column(name = "book_name", length = 30)
    private String book_name;

    @Column(name = "author", length = 30)
    private String author;

    @Column(name = "author_ID", nullable = false)
    private int authorId;

    @Column(name = "book_description", columnDefinition = "TEXT")
    private String bookDescription;

    @Column(name = "price", precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "genre", length = 30)
    private String genre;

    @Column(name = "publisher", length = 30)
    private String publisher;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "sold_copies")
    private int sold_copies;

}