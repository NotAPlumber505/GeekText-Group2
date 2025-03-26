package ShoppingCart.ShoppingCart.Repository;

import ShoppingCart.ShoppingCart.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
