package com.domain.mybatis.mappers;

import com.domain.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * Find every Roles
     * @return
     */
    List<Role> selectAll();
}
