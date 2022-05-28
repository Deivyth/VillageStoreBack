package com.villagestore.api.security.application.service;

import com.villagestore.api.security.domain.entity.User;
import com.villagestore.api.security.infraestructure.repository.UserRepository;
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
