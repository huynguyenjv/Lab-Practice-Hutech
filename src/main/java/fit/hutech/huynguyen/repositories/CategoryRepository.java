package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.Category;
import fit.hutech.huynguyen.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
