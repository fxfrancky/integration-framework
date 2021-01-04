/*
 * Copyright (c) 2021.  By François Xavier OWONA
 */

package com.domain.mybatis.mappers;

import com.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * Find every Users
     * @return
     */
    public List<User> selectUsers();

    /**
     * Get a user by login
     * @param login
     * @return
     */
    public User getUserByLogin(String login);

    /**
     * Create a user by every field
     * @param login
     * @param password
     * @param email
     */
    public void insertNewUser(@Param("login")String login, @Param("password")String password, @Param("email")String email);





}
