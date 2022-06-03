package com.villagestore.api.order.application;


import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    OrderDTO addOrder(OrderDTO orderDTO);
    void deleteOrders();
    Optional<OrderDTO> getOrderById(Long orderId);
}
