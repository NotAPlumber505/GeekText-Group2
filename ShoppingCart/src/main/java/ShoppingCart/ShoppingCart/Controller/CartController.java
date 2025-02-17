package ShoppingCart.ShoppingCart.Controller;

import ShoppingCart.ShoppingCart.Entity.Cart;
import ShoppingCart.ShoppingCart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public Cart postDetails(@RequestBody Cart cart){
        return cartService.saveDetails(cart);
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
