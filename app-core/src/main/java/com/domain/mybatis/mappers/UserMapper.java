/*
 * Copyright (c) 2021.  By François Xavier OWONA
 */

package com.domain.mybatis.mappers;

import com.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


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

    /**
     * Delete User By Login
     * @param login
     */
    public void  deleteUserByLogin(@Param("login")String login);

    /**
     * Delete All Users
     * @param logins
     */
    public void  deleteAllUsers(@Param("logins")List<String> logins );


    /**
     * Update User
     * @param usr
     */
    public void  updateUser(User usr);


    /**
     * Insert all users
     * @param usersList
     * @return
     */
    public void insertAllUsers(@Param("usersList") List<User> usersList);



}
