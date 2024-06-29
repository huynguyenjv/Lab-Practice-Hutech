package fit.hutech.huynguyen.controller;

import fit.hutech.huynguyen.entities.Order;
import fit.hutech.huynguyen.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<?> getOrdersBySearch(
            @RequestParam(value = "month" , name = "month") Optional<Integer> month,
            @RequestParam(value = "year" , name = "year") Optional<Integer> year
    ) {
        List<Order> orders = orderService.searchOrder(month,year);
        return ResponseEntity.ok().body(orders);
    }
}
