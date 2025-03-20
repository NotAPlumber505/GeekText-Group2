package com.BookInfo.BookInfo.Controller;


import com.BookInfo.BookInfo.Entity.Authors;
import com.BookInfo.BookInfo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public Authors postDetails(@RequestBody Authors authors)
    {
        return authorService.saveDetails(authors);
    }

    @GetMapping("/getAuthor")
    public List<Authors> getDetails(){
        return authorService.getAllDetails();

    }
}