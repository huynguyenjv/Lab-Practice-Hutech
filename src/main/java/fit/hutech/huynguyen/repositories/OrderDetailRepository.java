package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    Optional<List<OrderDetail>> findOrderDetailsByProductId(String ProductId);

}
