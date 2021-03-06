package com.springboot.management.mapper;

import com.springboot.management.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
/*
 *@Author 左创源
 * @date 2020/04/18
 *
 */
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
           @Result(property = "name",column = "name"),
            @Result(property = "img",column = "img"),
           @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.springboot.management.mapper.RoleMapper.findRoleByUserId"))
    })
    UserVO getUserByName(String username);


    UserVO getUserName(String username);

    //获取所有用户
    List<UserVO> findAllUser(Map<Object,Object> map);

    List<Classes> findAllClasses();

    List<Groups> findAllGroups();

    List<College> findAllCollege();

    List<Position> findAllPosition();

    int addUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int banUser(UserVO userVO);

    int banUserRows(List list);

    UserVO checkPhone(Map<String,Object> map);

    int changePwd(UserVO userVO);

    UserVO findUserByID(int id);

    List<RoleVO> findRolesByUid(int userId);

    int changeUserData(UserVO userVO);

    int deleteAll(@Param("userId") int userId);

    int updateRoles(@Param("roleId") String roleId, @Param("userId") int userId);

    int getMessageAll(int id);

    int getArticalAll(int id);

    int getQuestionAll(int id);

    int getCommentAll(int id);

    int getCommentQuantityAll(int id);

    UserVO checkUserName(String username);
}
