package com.villagestore.api.cart.application;


import java.util.List;

public interface CartService {
    List<CartDto> getUserCart(Long idUser);
    CartDto addObjectFromCart(CartDto cartDto);
    void deleteObjectFromCart(Long id);
    void deleteUserCart(Long idUser);
}
