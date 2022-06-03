package com.villagestore.api.order.infrastructure;

import com.villagestore.api.order.application.OrderDTO;
import com.villagestore.api.order.application.OrderService;
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

    @GetMapping(value = "/users/orders",  produces = "application/json")
    public ResponseEntity<List<OrderDTO>> getUserOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/users/orders/{orderId}", produces = "application/json")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
        return orderService
                .getOrderById(orderId)
                .map(orderDTO -> new ResponseEntity(orderDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/users/orders",  produces = "application/json")
    public ResponseEntity<OrderDTO> addUserOrders(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.addOrder(orderDTO);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/orders")
    public void deleteOrders() {
        orderService.deleteOrders();
    }
}
