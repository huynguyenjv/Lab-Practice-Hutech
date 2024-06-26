package fit.hutech.huynguyen.services;

import fit.hutech.huynguyen.entities.CartItem;
import fit.hutech.huynguyen.entities.CartItemResponse;
import fit.hutech.huynguyen.entities.Product;
import fit.hutech.huynguyen.repositories.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {
    @Getter
    private List<CartItem> cartItems = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(String productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
        CartItem cartItem = new CartItem(product, quantity, product.getPrice() * quantity);
        cartItems.add(cartItem);
    }

    public void removeFromCart(String productId) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public void updateQuantity(String productId, int quantity) {
        cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> item.setQuantity(quantity));
    }

    public Product getProductById(String productId) {
        return cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .map(CartItem::getProduct)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
    }

    public CartItem updateCart(String productId, int quantity) {
        CartItem cartItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));
        cartItem.setQuantity(quantity);
        cartItem.setTotal(cartItem.getProduct().getPrice() * quantity);
        return cartItem;
    }

    public void updateQuantity(Long productId, int quantity) {
        cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> item.setQuantity(quantity));
    }

    public void clearCart() {
        cartItems.clear();
    }
}
