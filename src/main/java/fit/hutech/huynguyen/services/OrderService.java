package fit.hutech.huynguyen.services;

import fit.hutech.huynguyen.entities.CartItem;
import fit.hutech.huynguyen.entities.Order;
import fit.hutech.huynguyen.entities.OrderDetail;
import fit.hutech.huynguyen.repositories.OrderDetailRepository;
import fit.hutech.huynguyen.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService;  // Assuming you have a CartService

    @Transactional
    public Order createOrder(Order customreOrder, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customreOrder.getCustomerName());
        order.setCustomerEmail(customreOrder.getCustomerEmail());
        order.setCustomerAddress(customreOrder.getCustomerAddress());
        order.setCustomerPhone(customreOrder.getCustomerPhone());
        order.setCustomerNote(customreOrder.getCustomerNote());
        order = orderRepository.save(order);

        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }
        // Optionally clear the cart after order placement
        cartService.clearCart();

        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> searchOrder(Optional<Integer> month, Optional<Integer> year) {
        return orderRepository.findOrdersByYearAndMonth(month.orElse(null), year.orElse(null));
    }
}
