package com.villagestore.api.user.infrastructure;

import com.villagestore.api.cart.application.CartDto;
import com.villagestore.api.user.application.dto.UserDto;
import com.villagestore.api.user.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return userService
                .getUserById(userId)
                .map(userDto -> new ResponseEntity(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        userDto = userService.addUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{userId}/cart", produces = "application/json")
    public ResponseEntity<List<CartDto>> getCartOfUser(@PathVariable Long userId) {
        List<CartDto> cartProductsDto = userService.getCartOfUser(userId);
        return new ResponseEntity<>(cartProductsDto, HttpStatus.OK);
    }

    @PutMapping(value = "/users/{userId}/cart", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<CartDto>> addProductToUserCart(
            @PathVariable Long userId,
            @RequestBody CartDto cartDto) {

        List<CartDto> cartProductsDto = userService.addProductToUserCart(userId,cartDto);
        return new ResponseEntity<>(cartProductsDto, HttpStatus.OK);
    }
}
