package fit.hutech.huynguyen.controller;

import fit.hutech.huynguyen.entities.Product;
import fit.hutech.huynguyen.entities.ProductResponse;
import fit.hutech.huynguyen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductApiController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        List<Product> listProduct = productService.getAllProducts();
        return listProduct.stream().map(ProductResponse::new).toList();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));

        ProductResponse productResponse = new ProductResponse(product);
        return ResponseEntity.ok().body(productResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id,
                                                 @RequestBody Product productDetails) {
        System.out.println("Update Product with ID = " + id + "...");
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        final Product updatedProduct = productService.addProduct(product);
        ProductResponse productResponse = new ProductResponse(updatedProduct);
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}