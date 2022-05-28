package com.villagestore.api.security.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.cart.application.CartMapper;
import com.villagestore.api.security.application.dto.UserDTO;
import com.villagestore.api.security.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CartMapper.class })
public interface UserMapper extends EntityMapper<UserDTO, User> {

    default User fromId(Long id) {
        if(id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

}
