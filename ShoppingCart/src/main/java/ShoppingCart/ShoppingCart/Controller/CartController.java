package ShoppingCart.ShoppingCart.Controller;

import ShoppingCart.ShoppingCart.Entity.Cart;
import ShoppingCart.ShoppingCart.Service.CartService;
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

    @PostMapping("/addCart")
    public ResponseEntity<Map<String, Object>> postDetails(@RequestBody Cart cart) {
        Cart savedCart = this.cartService.saveDetails(cart);
        Map<String, Object> response = new HashMap();
        response.put("message", "Book added to cart successfully!");
        response.put("cart", savedCart);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getAllCarts")
    public List<Cart> getDetails(){
        return cartService.getAllDetails();
    }

    @GetMapping("/getCart/{cart_id}")
    public Cart fetchCartById(@PathVariable int cart_id){
        return cartService.getCartById(cart_id);
    }

}
