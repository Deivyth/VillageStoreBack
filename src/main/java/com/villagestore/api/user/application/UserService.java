package com.villagestore.api.user.application;

import java.util.Optional;

public interface UserService {
    Optional<UserSimpleDto> getUserById(Long id);
    UserDto addUser(UserDto userDto);
}
