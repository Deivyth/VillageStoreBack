package com.villagestore.api.cart.infrastructure;

import com.villagestore.api.cart.application.CartDto;
import com.villagestore.api.cart.application.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/users/{userId}/cart",  produces = "application/json")
    public ResponseEntity<List<CartDto>> getUserCart(@PathVariable Long userId) {
        List<CartDto> userCart = cartService.getUserCart(userId);
        return new ResponseEntity<>(userCart, HttpStatus.OK);
    }

    @PostMapping(value = "/users/cart", produces = "application/json", consumes = "application/json" )
    public ResponseEntity<CartDto> addProductAtCart(@RequestBody CartDto cartDto) {
        CartDto saveCartDto = cartService.addObjectFromCart(cartDto);
        return new ResponseEntity<>(saveCartDto, HttpStatus.OK);
    }

    @PutMapping(value = "/users/cart", produces = "application/json", consumes = "application/json" )
    public ResponseEntity<CartDto> updateProductAtCart(@RequestBody CartDto cartDto) {
        CartDto saveCartDto = cartService.addObjectFromCart(cartDto);
        return new ResponseEntity<>(saveCartDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/cart/{cartId}")
    public ResponseEntity<CartDto> deleteProductById(@PathVariable Long cartId) {
        cartService.deleteObjectFromCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{userId}/cart")
    public ResponseEntity<CartDto> deleteUserCart(@PathVariable Long userId) {
        cartService.deleteUserCart(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
