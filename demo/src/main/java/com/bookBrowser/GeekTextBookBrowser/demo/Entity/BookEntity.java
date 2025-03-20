package com.bookBrowser.GeekTextBookBrowser.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Book_DB")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @Column(name = "BOOK ID")
    @GeneratedValue
    private int bookId;

    @Column(name = "BOOK TITLE", precision = 255, nullable = false)
    private String title;

    @Column(name = "GENRE ID")
    private int genreId;

    @Column(name = "AUTHOR ID")
    private int authorId;

    @Column (name = "SALE QUANTITY")
    private int saleQuantity;

    @Column(name = "RATING")
    private double rating;

    @Column(name = "PRICE", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;

    @Column(name = "PUBLISHER", precision = 255, nullable = false)
    private String publisher;

}
