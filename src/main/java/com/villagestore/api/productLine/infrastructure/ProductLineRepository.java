package com.villagestore.api.productLine.infrastructure;

import com.villagestore.api.productLine.domain.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

}
