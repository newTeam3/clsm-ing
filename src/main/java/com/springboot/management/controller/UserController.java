package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.UserService;
import com.springboot.management.vo.RoleVO;
import com.springboot.management.vo.Task;
import com.springboot.management.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
/*
 *@Author 左创源
 * @date 2020/04/18
 * 用户模块的控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    //用户模块只有超级管理员的角色才能访问
    //获取所有用户信息
    @PreAuthorize("hasRole('root')")
    @PostMapping(value = "/findAllUser")
    public ResponseEntity<?> findAllUser(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = userService.findAllUser(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //得到下拉菜单中需要动态渲染的数据
    @GetMapping(value = "/getSearchData")
    public ResponseEntity<?> getSearchData() {
        Map<String, Object> map = userService.getSearchData();
        return ResponseEntity.ok(map);
    }
    //新添加一个用户
    @PostMapping(value = "/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserVO userVO) {
        String encode = passwordEncoder.encode(userVO.getPassword());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        userVO.setPassword(encode);
        userVO.setCreated(timestamp);
        userService.addUser(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //修改一个用户信息
    @PostMapping(value = "/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserVO userVO) {
        String encode = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encode);
        userService.updateUser(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //禁用一个用户
    @PostMapping(value = "/banUser")
    public ResponseEntity<?> banUser(@RequestBody UserVO userVO) {
        userService.banUser(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用用户
    @GetMapping(value = "/banUserRows")
    public ResponseEntity<?> banUserRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        userService.banUserRows(list);
        return ResponseEntity.ok("操作成功");
    }
    //检查短信验证的手机号是否与用户绑定的手机号一致
    @GetMapping(value = "/checkPhone")
    public ResponseEntity<?> checkPhone(@RequestParam("id") int id,@RequestParam("phone") String phone) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("phone",phone);
        UserVO userVO = userService.checkPhone(map);
        return ResponseEntity.ok(userVO);
    }
    //修改密码
    @PostMapping(value = "/changePwd")
    public ResponseEntity<?> changePwd(@RequestBody UserVO userVO) {
        String encode = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encode);
        userService.changePwd(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //通过id查找用户的详细信息
    @GetMapping(value = "/findUserByID")
    public ResponseEntity<?> findUserByID(@RequestParam("id") int id) {
        UserVO userVO=userService.findUserByID(id);
        return ResponseEntity.ok(userVO);
    }
    //前台修改个人资料
    @PostMapping(value = "/changeUserData")
    public ResponseEntity<?> changeUserData(@RequestBody UserVO userVO) {
        userService.changeUserData(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //查找用户所具有的角色
    @GetMapping(value = "/findRolesByUid")
    public ResponseEntity<?> findRolesByUid(@RequestParam("userId") int userId) {
        List<RoleVO> list=userService.findRolesByUid(userId);
        return ResponseEntity.ok(list);
    }
    //分配管理用户的角色
    @GetMapping(value = "/updateRoles")
    public ResponseEntity<?> updateRoles(@RequestParam("ids") String ids,@RequestParam("userId") int userId) {
        List<String> list = Arrays.asList(ids.split(","));
        int i = userService.deleteAll(userId);
        userService.updateRoles(list,userId);
        return ResponseEntity.ok("操作成功");
    }
    //个人中心的数据统计
    @GetMapping(value = "/getTotalData")
    public ResponseEntity<?> getTotalData(@RequestParam("id") int id) {
        Map<String, Object> map = userService.getTotalData(id);
        return ResponseEntity.ok(map);
    }
    //检查用户名是否已存在
    @GetMapping(value = "/checkUserName")
    public ResponseEntity<?> checkUserName(@RequestParam("username") String username) {
        UserVO userVO = userService.checkUserName(username);
        return ResponseEntity.ok(userVO);
    }
}
