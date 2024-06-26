package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
