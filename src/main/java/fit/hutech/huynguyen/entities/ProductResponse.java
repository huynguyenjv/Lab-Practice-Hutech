package fit.hutech.huynguyen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private double price;
    private String description;

    private String categoryId;
    private String categoryName;
    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categoryId = product.getCategory().getId();
        this.categoryName = product.getCategory().getName();
    }
}
