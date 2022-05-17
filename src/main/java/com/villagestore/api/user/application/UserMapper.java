package com.villagestore.api.user.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.cart.application.CartMapper;
import com.villagestore.api.user.application.dto.UserDto;
import com.villagestore.api.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CartMapper.class })
public interface UserMapper extends EntityMapper<UserDto, User> {

    default User fromId(Long id) {
        if(id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
