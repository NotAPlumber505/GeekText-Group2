package ShoppingCart.ShoppingCart.Service;

import ShoppingCart.ShoppingCart.Entity.Book;
import ShoppingCart.ShoppingCart.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book saveDetails(Book book){

        return bookRepo.save(book);
    }

    public List<Book> getAllDetails(){

        return bookRepo.findAll();
    }

    public Book getBookById(int book_id){

        return bookRepo.findById(book_id).orElse(null);
    }
}
