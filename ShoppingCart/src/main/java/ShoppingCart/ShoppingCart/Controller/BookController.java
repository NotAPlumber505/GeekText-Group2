package ShoppingCart.ShoppingCart.Controller;

import ShoppingCart.ShoppingCart.Entity.Book;
import ShoppingCart.ShoppingCart.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book postDetails(@RequestBody Book book){

        return bookService.saveDetails(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getDetails(){
        return bookService.getAllDetails();
    }

    @GetMapping("/getBook/{book_id}")
    public Book fetchBookById(@PathVariable int book_id){
        return bookService.getBookById(book_id);
    }
}
