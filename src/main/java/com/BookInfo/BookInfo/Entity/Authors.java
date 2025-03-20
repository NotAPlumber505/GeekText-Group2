package com.BookInfo.BookInfo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Authors {

    //All the variables
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Column(name = "first_name", length = 30)
    private String first_name;

    @Column(name = "last_name", length = 30)
    private String last_name;

    @Column(name = "publisher", length = 30)
    private String publisher;

}
