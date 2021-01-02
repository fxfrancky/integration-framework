package com.domain.converter;

import com.domain.dto.UserDTO;
import com.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    List<UserDTO> map(List<User> users);
    User UserDTOToUserMapper(UserDTO userDTO);
    UserDTO UserToUserDTOMapper(User usr);

}
