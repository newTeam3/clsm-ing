package com.springboot.management.vo;
/*
 *@Author 左创源
 * @date 2020/04/12
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    //主键
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //电话号码
    private String phone;
    //创建时间
    private Date created;
    //密码修改时间用于jwt
    private Date lastPasswordResetDate;
    //用户状态
    private int status;
    //性别
    private int sex;

    private String img;

    //班级id
    private int cid;
    //职称id
    private int pid;
    //组id
    private int gid;
    //学院id
    private int coid;

    private String cidName;
    private String pidName;
    private String gidName;
    private String coidName;

    private List<RoleVO> roles;
}
