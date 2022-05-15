package com.villagestore.api.user.application;

import com.villagestore.api.user.domain.User;
import com.villagestore.api.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<UserSimpleDto> getUserById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toSimpleDto);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
}
