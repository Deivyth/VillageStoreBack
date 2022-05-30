package com.villagestore.api.cart.infrastructure;

import com.villagestore.api.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(Long id);

    void deleteAllByUserId(Long id);
}
