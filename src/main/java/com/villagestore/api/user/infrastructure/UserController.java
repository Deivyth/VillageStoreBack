package com.villagestore.api.user.infrastructure;

import com.villagestore.api.user.application.UserDto;
import com.villagestore.api.user.application.UserService;
import com.villagestore.api.user.application.UserSimpleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json")
    public ResponseEntity<UserSimpleDto> getUserById(@PathVariable Long userId) {
        return userService
                .getUserById(userId)
                .map(userSimpleDto -> new ResponseEntity(userSimpleDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        userDto = userService.addUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
