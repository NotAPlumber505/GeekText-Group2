package com.geektext.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private String saleDate;
    private int quantity;
}
