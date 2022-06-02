package com.villagestore.api.productLine.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.cart.domain.Cart;
import com.villagestore.api.order.application.OrderMapper;
import com.villagestore.api.product.application.ProductMapper;
import com.villagestore.api.productLine.domain.ProductLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, OrderMapper.class })
public interface ProductLineMapper extends EntityMapper<ProductLineDTO, ProductLine> {

    @Override
    @Mapping(source = "orderId", target = "order.id")
    @Mapping(source = "productId", target = "product.id")
    ProductLine toEntity(ProductLineDTO dto);

    @Override
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.image", target = "productImage")
    ProductLineDTO toDto(ProductLine entity);

    default ProductLine fromId(Long id) {
        if(id == null) return null;
        ProductLine productLine = new ProductLine();
        productLine.setId(id);
        return  productLine;
    }

}
