package ShoppingCart.ShoppingCart.Service;

import ShoppingCart.ShoppingCart.Entity.Cart;
import ShoppingCart.ShoppingCart.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public Cart saveDetails(Cart cart){

        return cartRepo.save(cart);
    }

    public List<Cart> getAllDetails(){
        return cartRepo.findAll();
    }

    public Cart getCartById(int cart_id){
        return cartRepo.findById(cart_id).orElse(null);
    }
}
