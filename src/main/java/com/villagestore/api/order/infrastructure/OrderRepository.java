package com.villagestore.api.order.infrastructure;

import com.villagestore.api.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
