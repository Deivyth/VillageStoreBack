package com.villagestore.api.order.application;


import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    OrderDTO addOrder(OrderDTO orderDTO);

}
