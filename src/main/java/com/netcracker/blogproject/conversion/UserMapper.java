package com.netcracker.blogproject.conversion;

import com.netcracker.blogproject.dto.UserDTO;
import com.netcracker.blogproject.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(target = "userId", source = "entity.userId"),
            @Mapping(target = "userLastName", source = "entity.userLastName"),
            @Mapping(target = "userFirstName", source = "entity.userFirstName"),
            @Mapping(target = "userMiddleName", source = "entity.userMiddleName"),
            @Mapping(target = "userMail", source = "entity.userMail"),
            @Mapping(target = "userPhone", source = "entity.userPhone"),
            @Mapping(target = "userLogin", source = "entity.userLogin"),
            @Mapping(target = "userPassword", source = "entity.userPassword"),
            @Mapping(target = "userNickName", source = "entity.userNickName"),
            @Mapping(target = "userAdmin", source = "entity.userAdmin"),
            @Mapping(target = "userStatusOfActivity", source = "entity.userStatusOfActivity")
    })
    UserDTO userToUserDTO(User entity);

    @Mappings({
            @Mapping(target = "userId", source = "dto.userId"),
            @Mapping(target = "userLastName", source = "dto.userLastName"),
            @Mapping(target = "userFirstName", source = "dto.userFirstName"),
            @Mapping(target = "userMiddleName", source = "dto.userMiddleName"),
            @Mapping(target = "userMail", source = "dto.userMail"),
            @Mapping(target = "userPhone", source = "dto.userPhone"),
            @Mapping(target = "userLogin", source = "dto.userLogin"),
            @Mapping(target = "userPassword", source = "dto.userPassword"),
            @Mapping(target = "userNickName", source = "dto.userNickName"),
            @Mapping(target = "userAdmin", source = "dto.userAdmin"),
            @Mapping(target = "userStatusOfActivity", source = "dto.userStatusOfActivity")
    })
    User userDTOtoUser(UserDTO dto);

}