package com.BookInfo.BookInfo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Authors {

    //All the variables
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("biography")
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @JsonProperty("first_name")
    @Column(name = "first_name", length = 30)
    private String first_name;

    @JsonProperty("last_name")
    @Column(name = "last_name", length = 30)
    private String last_name;

    @JsonProperty("publisher")
    @Column(name = "publisher", length = 30)
    private String publisher;

}
