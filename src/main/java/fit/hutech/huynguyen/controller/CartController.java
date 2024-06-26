package fit.hutech.huynguyen.controller;

import fit.hutech.huynguyen.entities.CartItem;
import fit.hutech.huynguyen.entities.CartItemResponse;
import fit.hutech.huynguyen.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "/cart/cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam String productId, @RequestParam int
            quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable String productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }
    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @ResponseBody
    @PostMapping("/api/update")
    public List<CartItemResponse> updateQuantity(@RequestParam String productId, @RequestParam int quantity) {
        System.out.println("ccc");
        cartService.updateQuantity(productId, quantity);
        List<CartItem> carts = cartService.getCartItems();
        return carts.stream().map(CartItemResponse::new).toList();
    }
}
