package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("SELECT o FROM Order o WHERE (:month IS NULL OR FUNCTION('MONTH', o.orderDate) = :month) AND (:year IS NULL OR FUNCTION('YEAR', o.orderDate) = :year)")
    List<Order> findOrdersByYearAndMonth(
            @Param("month") Integer month,
            @Param("year") Integer year
    );
}
