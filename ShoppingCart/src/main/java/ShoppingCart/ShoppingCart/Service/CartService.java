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

    public Cart saveDetails(Cart cart, List<Integer> bookIds) {
        // Fetch books based on bookIds
        List<Book> books = bookRepo.findAllById(bookIds);
        if (books.isEmpty()) {
            throw new RuntimeException("No valid books found for IDs: " + bookIds);
        }

        // Set books to cart
        cart.setBooks(books);

        // Save and return the cart
        return cartRepo.save(cart);
    }

    public List<Cart> getAllDetails() {
        return cartRepo.findAll();
    }


    public Cart getCartById(int cart_id) {
        return cartRepo.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public String deleteCartById(int cart_id) {
        if (!cartRepo.existsById(cart_id)) {
            return "Cart not found!";
        }
        cartRepo.deleteById(cart_id);
        return "Deleted cart " + cart_id;
    }

    public String removeBookFromCart(int cartId, int bookId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getBooks().removeIf(book -> book.getBookId() == bookId);

        cartRepo.save(cart);
        return "Removed book " + bookId + " from cart " + cartId;
    }



}
