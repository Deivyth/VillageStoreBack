package com.villagestore.api.order.application;


import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDTO> findByUserId(Long userId);
    OrderDTO addOrder(OrderDTO orderDTO);
    void deleteOrders();
    Optional<OrderDTO> getOrderById(Long orderId);
}
