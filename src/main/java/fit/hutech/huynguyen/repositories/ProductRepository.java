package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.Product;
import fit.hutech.huynguyen.entities.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE  ( p.name LIKE %?1% or  ?1 = '') and ( p.price >= ?2 or ?2 = 0.0 ) and ( p.price <= ?3 or ?3 = 0.0)")
    public List<Product> findProductsByName(Optional<String> name, Optional<Double> priceMin , Optional<Double> priceMax);
}
