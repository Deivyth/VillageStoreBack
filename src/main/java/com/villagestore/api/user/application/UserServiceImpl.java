package com.villagestore.api.user.application;

import com.villagestore.api.cart.application.CartDto;
import com.villagestore.api.user.application.dto.UserDto;
import com.villagestore.api.user.domain.User;
import com.villagestore.api.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUserById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toDto);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public List<CartDto> addProductToUserCart(Long userId, CartDto cartDto) {
        UserDto userDto = getUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        cartDto.setUserId(userId);
        userDto.getCart().add(cartDto);
        User user = userRepository.save(userMapper.toEntity(userDto));
        userDto = userMapper.toDto(user);

        return userDto.getCart();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartDto> getCartOfUser(Long userId) {
        UserDto userDto = getUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return userDto.getCart();
    }
}
