package com.domain.service;

import com.domain.dao.UserRoleDAO;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
@Slf4j
public class UserRoleService {

    @Inject
    private UserRoleDAO userRoleDAO;



}
