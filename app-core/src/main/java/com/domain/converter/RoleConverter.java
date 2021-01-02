package com.domain.converter;

import com.domain.dto.RoleDTO;
import com.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConverter {

   RoleConverter INSTANCE = Mappers.getMapper(RoleConverter.class);

    List<RoleDTO> map(List<Role> roles);
    Role RoleDTOToRoleMapper(RoleDTO roleDTO);
    RoleDTO RoleToRoleDTOMapper(Role role);
}
