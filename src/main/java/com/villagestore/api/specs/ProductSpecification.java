package com.villagestore.api.specs;

import com.villagestore.api.product.domain.Product;
import com.villagestore.api.specs.shared.EntitySpecification;
import com.villagestore.api.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductSpecification extends EntitySpecification<Product> implements Specification<Product> {

    public ProductSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }



}
