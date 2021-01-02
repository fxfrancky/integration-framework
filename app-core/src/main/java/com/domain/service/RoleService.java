package com.domain.service;

import com.domain.converter.RoleConverter;
import com.domain.dao.RoleDAO;
import com.domain.dto.RoleDTO;
import com.domain.model.Role;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
@Slf4j
public class RoleService {

    @Inject
    private RoleDAO roleDAO;

    public List<RoleDTO> getAllRoles() throws Exception {
        List<Role> roles = roleDAO.findAllRoles();
        List<RoleDTO> allRolesDTO = RoleConverter.INSTANCE.map(roles);
        return  allRolesDTO;
    }


}
