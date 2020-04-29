package com.springboot.management.mapper;

import com.springboot.management.vo.UserVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    @Results({
           @Result(id = true,property = "id",column = "id"),
           @Result(property = "username",column = "username"),
           @Result(property = "password",column = "password"),
           @Result(property = "phone",column = "phone"),
           @Result(property = "created",column = "created"),
           @Result(property = "status",column = "status"),
           @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.springboot.management.mapper.RoleMapper.findRoleByUserId"))
    })
    UserVO getUserByName(String username);

}
