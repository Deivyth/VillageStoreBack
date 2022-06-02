package com.villagestore.api.order.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.order.domain.Order;
import com.villagestore.api.productLine.application.ProductLineMapper;
import com.villagestore.api.security.application.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class, ProductLineMapper.class })
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Override
    @Mapping(source = "userId", target = "user")
    Order toEntity(OrderDTO dto);

    @Override
    @Mapping(source = "user.id", target = "userId")
    OrderDTO toDto(Order entity);

}
