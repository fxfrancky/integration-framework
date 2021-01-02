package com.domain.dao;

import com.domain.model.UserRole;
import com.domain.mybatis.mappers.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
@Slf4j
public class UserRoleDAO {

    @Inject
    UserRoleMapper userRoleMapper;

    public List<UserRole> findAllUserRoles(){
        return  userRoleMapper.selectAll();
    }
}
