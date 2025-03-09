package ShoppingCart.ShoppingCart.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue
    private int cart_id;

    @Column(name = "user_id")
    private int user_id;

    @OneToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "book_id"
    )
    private Book book;

    @Column(name = "quantity")
    private int quantity;
}
