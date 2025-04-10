package ShoppingCart.ShoppingCart.Controller;

import ShoppingCart.ShoppingCart.Entity.Cart;
import ShoppingCart.ShoppingCart.Service.CartService;
import ShoppingCart.ShoppingCart.dto.CartRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addCart(@RequestBody CartRequest cartRequest) {
        Cart cart = new Cart();
        cart.setUserId(cartRequest.getUserId());  // Associate cart with user

        Cart savedCart = cartService.saveDetails(cart, cartRequest.getBookIds());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Books added to cart successfully!");
        response.put("cart", savedCart);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllDetails());
    }


    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }


    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable int cartId) {
        String message = cartService.deleteCartById(cartId);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/{cartId}/removeBook/{bookId}")
    public ResponseEntity<String> removeBook(@PathVariable int cartId, @PathVariable int bookId) {
        String message = cartService.removeBookFromCart(cartId, bookId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/subtotal")
    public ResponseEntity<Map<String, Object>> getCartSubtotal(@RequestParam int cartId) {
        try {
            double subtotal = cartService.calculateCartSubtotalByCartId(cartId);

            Map<String, Object> response = new HashMap<>();
            response.put("cartId", cartId);
            response.put("subtotal", subtotal);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();  // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
