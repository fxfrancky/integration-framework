package com.domain.service;

import com.domain.converter.UserConverter;
import com.domain.dao.UserDAO;
import com.domain.dto.UserDTO;
import com.domain.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
@Slf4j
public class UserService {

    @Inject
    private UserDAO userDAO;

    public List<UserDTO> getAllUsers() throws Exception {
        List<User> users = userDAO.findAllUsers();
        List<UserDTO> allUsersDTO = UserConverter.INSTANCE.map(users);
        return  allUsersDTO;
    }


}
