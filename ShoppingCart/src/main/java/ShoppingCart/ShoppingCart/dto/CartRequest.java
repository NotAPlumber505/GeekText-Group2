package ShoppingCart.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private int userId;
    private List<Integer> bookIds;
}
