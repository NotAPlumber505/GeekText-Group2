package com.geektext.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreName;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;
}
