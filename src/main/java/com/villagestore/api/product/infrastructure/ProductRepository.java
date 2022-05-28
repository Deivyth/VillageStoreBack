package com.villagestore.api.product.infrastructure;

import com.villagestore.api.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCategoryId(Long id);
}
