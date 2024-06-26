package fit.hutech.huynguyen.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private Product product;
    private int quantity;
    private double total;
    // Constructors
    public CartItem(Product product, int quantity, double total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

}
