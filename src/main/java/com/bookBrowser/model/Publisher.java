package com.bookBrowser.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;
    private String publisherName;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
