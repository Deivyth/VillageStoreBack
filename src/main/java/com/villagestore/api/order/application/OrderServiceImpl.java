package com.villagestore.api.order.application;

import com.villagestore.api.order.domain.Order;
import com.villagestore.api.order.infrastructure.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDto(orders);
    }
    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {
        orderDTO.setDate(new Date());
        Order order = orderRepository.save(orderMapper.toEntity(orderDTO));
        return orderMapper.toDto(order);
    }
}
