package com.domain.mybatis.mappers;

import com.domain.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    /**
     * Find every UserRole
     * @return
     */
    List<UserRole> selectAll();
}
