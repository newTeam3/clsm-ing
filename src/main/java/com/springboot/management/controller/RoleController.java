package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.RoleService;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 *@Author 左创源
 * @date 2020/05/16
 * 用户角色的分配及管理
 */

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    //角色菜单栏只允许拥有超级管理员权限的账号访问
    //查询所有角色
    @PreAuthorize("hasRole('root')")
    @PostMapping(value = "/findAllRoles")
    public ResponseEntity<?> findAllRoles(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = roleService.findAllRoles(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //添加一个角色
    @PostMapping(value = "/addRole")
    public ResponseEntity<?> addRole(@RequestBody RoleVO roleVO) {
        roleService.addRole(roleVO);
        return ResponseEntity.ok("操作成功");
    }
    //修改角色信息
    @PostMapping(value = "/updateRole")
    public ResponseEntity<?> updateRole(@RequestBody RoleVO roleVO) {
        roleService.updateRole(roleVO);
        return ResponseEntity.ok("操作成功");
    }

}
