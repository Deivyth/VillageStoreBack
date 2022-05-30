package com.villagestore.api.cart.application;

import com.villagestore.api.cart.domain.Cart;
import com.villagestore.api.cart.infrastructure.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartDto> getUserCart(Long idUser) {
        List<Cart> userCart = cartRepository.findAllByUserId(idUser);
        return cartMapper.toDto(userCart);
    }

    @Override
    @Transactional
    public CartDto addObjectFromCart(CartDto cartDto) {
        Cart cart = cartRepository.save(cartMapper.toEntity(cartDto));
        return cartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public void deleteObjectFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserCart(Long id) {
        cartRepository.deleteAllByUserId(id);
    }
}
