package ShoppingCart.ShoppingCart.Repository;

import ShoppingCart.ShoppingCart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
