package fit.hutech.huynguyen.controller;


import fit.hutech.huynguyen.entities.CartItem;
import fit.hutech.huynguyen.entities.Order;
import fit.hutech.huynguyen.entities.OrderDetail;
import fit.hutech.huynguyen.services.CartService;
import fit.hutech.huynguyen.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("order", new Order());
        return "/cart/checkout";
    }
    @PostMapping("/submit")
    public String submitOrder(@Valid Order order) {
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart"; // Redirect if cart is empty
        }
        orderService.createOrder(order, cartItems);
        return "redirect:/order/confirmation";
    }

    @GetMapping("/confirmation")
    public String orderConfirmation(Model model) {
        model.addAttribute("message", "Your order has been successfully placed.");
        return "cart/order-confirmation";
    }



    @GetMapping
    public String order(Model model, @RequestParam(required = false) Integer month,
                        @RequestParam(required = false) Integer year) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);

        List<Integer> months = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            months.add(i);
        }

        List<Integer> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= 2000; i--) {
            years.add(i);
        }

        model.addAttribute("months", months);
        model.addAttribute("years", years);

        model.addAttribute("selectedMonth", month);
        model.addAttribute("selectedYear", year);
        return "orders/order-list";
    }


    @GetMapping("/{id}")
    public String orderDetails(@PathVariable String id, Model model) {
        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "/orders/order-details";
    }




}
