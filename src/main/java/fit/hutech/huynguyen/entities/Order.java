package fit.hutech.huynguyen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}