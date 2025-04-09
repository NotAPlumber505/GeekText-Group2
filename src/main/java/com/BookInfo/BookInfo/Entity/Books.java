package com.BookInfo.BookInfo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ISBN", nullable = false, unique = true)
    private Long isbn;

    @Column(name = "book_name", length = 30)
    private String book_name;

    @Column(name = "author", length = 30)
    private String author;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Authors author_id;

    @JsonProperty("book_description")
    @Column(name = "book_description", columnDefinition = "TEXT")
    private String bookDescription;

    @Column(name = "price", precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "genre", length = 30)
    private String genre;

    @Column(name = "publisher", length = 30)
    private String publisher;

    @JsonProperty("publish_year")
    @Column(name = "publish_year")
    private Long publishYear;

    @JsonProperty("sold_copies")
    @Column(name = "sold_copies")
    private Long sold_copies;

}