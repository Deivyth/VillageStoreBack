package com.villagestore.api.security.service;

import com.villagestore.api.security.entity.User;
import com.villagestore.api.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    //TO DO
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByEmail(String userName){
        return userRepository.findByEmail(userName);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
