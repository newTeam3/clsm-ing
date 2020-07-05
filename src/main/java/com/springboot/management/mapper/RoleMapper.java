package com.springboot.management.mapper;
/*
 *@Author 左创源
 * @date 2020/05/16
 *
 */
import com.springboot.management.vo.Position;
import com.springboot.management.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    @Select("select * from role where id in(select roleId from user_role where userId = #{userId})")
    List<RoleVO> findRoleByUserId(int userId);

    List<RoleVO> findAllRoles(Map<Object,Object> map);

    int addRole(RoleVO roleVO);

    int updateRole(RoleVO roleVO);
}
