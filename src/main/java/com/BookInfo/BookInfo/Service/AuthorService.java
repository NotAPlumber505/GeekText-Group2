package com.BookInfo.BookInfo.Service;

import com.BookInfo.BookInfo.Entity.Authors;
import com.BookInfo.BookInfo.Repository.AuthorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepo authorsRepo;

    public Authors saveDetails(Authors authors){

        return authorsRepo.save(authors);
    }

    public List<Authors> getAllDetails(){

        return authorsRepo.findAll();
    }
}
