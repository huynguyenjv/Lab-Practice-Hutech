package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
