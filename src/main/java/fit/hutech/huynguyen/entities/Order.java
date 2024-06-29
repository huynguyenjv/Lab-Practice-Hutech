package fit.hutech.huynguyen.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String customerNote;
    private String customerPaymentMethod = "Cash on delivery";
    private Timestamp orderDate = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public double total() {
        List<OrderDetail> orderDetails = getOrderDetails();
        double total = 0;
        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.getProduct().getPrice() * orderDetail.getQuantity();
        }

        return total;
    }

    public String truncateNotes() {
        if (customerNote.length() > 20) {
            return customerNote.substring(0, 20) + "...";
        }
        return customerNote;
    }
}