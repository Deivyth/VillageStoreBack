package com.villagestore.api.order.infrastructure;

import com.villagestore.api.order.application.OrderDTO;
import com.villagestore.api.order.application.OrderService;
import com.villagestore.api.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/users/{userId}/orders",  produces = "application/json")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable Long userId) {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping(value = "/users/orders",  produces = "application/json")
    public ResponseEntity<OrderDTO> addUserOrders(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.addOrder(orderDTO);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }
}
