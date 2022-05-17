package com.villagestore.api.user.application;

import com.villagestore.api.cart.application.CartDto;
import com.villagestore.api.user.application.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDto> getUserById(Long id);
    UserDto addUser(UserDto userDto);
    List<CartDto> addProductToUserCart(Long userId, CartDto cartDto);
    List<CartDto> getCartOfUser(Long userId);
}
