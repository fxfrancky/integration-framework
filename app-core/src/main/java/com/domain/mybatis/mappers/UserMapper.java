/*
 * Copyright (c) 2021.  By François Xavier OWONA
 */

package com.domain.mybatis.mappers;

import com.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * Find every Users
     * @return
     */
    List<User> selectUsers();

    User getUserByIdUser(Integer idUser);

//    @Select("select * from company where id = #{id}")
//    Company getCompanyById(Integer id);

}
