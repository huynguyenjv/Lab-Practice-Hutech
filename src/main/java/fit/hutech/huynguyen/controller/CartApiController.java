package fit.hutech.huynguyen.controller;

import fit.hutech.huynguyen.entities.CartItem;
import fit.hutech.huynguyen.entities.CartItemResponse;
import fit.hutech.huynguyen.entities.ProductResponse;
import fit.hutech.huynguyen.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartApiController {

    private CartService cartService;

//    @PostMapping("/update/{productId}")
//    public ResponseEntity<CartItemResponse> cartUpdate(@PathVariable String productId, @RequestParam int quantity) {
//        cartService.getProductById(productId);
//        return ResponseEntity.ok(cartService.updateCart(productId, quantity));
//    }
}
