package com.springboot.management.mapper;

import com.springboot.management.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role where id in(select roleId from user_role where userId = #{userId})")
    List<RoleVO> findRoleByUserId(int userId);

}
