package com.villagestore.api.product.infrastructure;

import com.villagestore.api.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> { }
