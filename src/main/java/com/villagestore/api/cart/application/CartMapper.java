package com.villagestore.api.cart.application;


import com.villagestore.api.EntityMapper;
import com.villagestore.api.cart.CartKey;
import com.villagestore.api.cart.domain.Cart;
import com.villagestore.api.product.application.ProductMapper;
import com.villagestore.api.security.application.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class, ProductMapper.class })
public interface CartMapper extends EntityMapper<CartDto, Cart> {

    @Override
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "userId", target = "id.userId")
    @Mapping(source = "productId", target = "product")
    @Mapping(source = "productId", target = "id.productId")
    Cart toEntity(CartDto dto);

    @Override
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "productPrice")
    @Mapping(source = "product.image", target = "productImage")
    CartDto toDto(Cart entity);

    default Cart fromId(CartKey id) {
        if(id == null) return null;
        Cart cart = new Cart();
        cart.setId(id);
        return  cart;
    }
}
