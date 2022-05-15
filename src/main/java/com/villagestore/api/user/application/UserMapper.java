package com.villagestore.api.user.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "address", ignore = true)
    User toEntity(UserSimpleDto userSimpleDto);
    UserSimpleDto toSimpleDto(User user);

    default User fromId(Long id) {
        if(id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
