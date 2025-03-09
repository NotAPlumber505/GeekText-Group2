package ShoppingCart.ShoppingCart.Service;

import ShoppingCart.ShoppingCart.Entity.Book;
import ShoppingCart.ShoppingCart.Entity.Cart;
import ShoppingCart.ShoppingCart.Repository.BookRepo;
import ShoppingCart.ShoppingCart.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private BookRepo bookRepo;

    public Cart saveDetails(Cart cart){

        Book book = (Book)this.bookRepo.findById(cart.getBook().getBook_id()).orElseThrow(() -> {
            return new RuntimeException("Book not found");
        });
        cart.setBook(book);
        cart.setQuantity(cart.getQuantity());
        return (Cart)this.cartRepo.save(cart);
    }

    public List<Cart> getAllDetails(){
        return cartRepo.findAll();
    }

    public Cart getCartById(int cart_id){
        return cartRepo.findById(cart_id).orElse(null);
    }
}
