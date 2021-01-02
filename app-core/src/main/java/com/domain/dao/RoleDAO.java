package com.domain.dao;

import com.domain.model.Role;
import com.domain.mybatis.factory.MyBatisSqlSessionFactory;
import com.domain.mybatis.mappers.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
@Slf4j
public class RoleDAO {

    @Inject
    RoleMapper roleMapper;

    public List<Role> findAllRoles() throws Exception {

        List<Role> roles = null;
        try{
//            SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
//            RoleMapper roleMapper= session.getMapper(RoleMapper.class);
            roles = roleMapper.selectAll();
        }catch (Exception e){
            throw new Exception("RoleDAO Exception " + e.getMessage());
        }
        return roles;
    }
}
