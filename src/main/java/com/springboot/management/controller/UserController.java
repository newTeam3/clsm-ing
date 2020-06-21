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

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('root')")
    @PostMapping(value = "/findAllUser")
    public ResponseEntity<?> findAllUser(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = userService.findAllUser(pageVO);
        System.out.println("这是所有用户"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    @GetMapping(value = "/getSearchData")
    public ResponseEntity<?> getSearchData() {
        Map<String, Object> map = userService.getSearchData();
        System.out.println("map" +map);
        return ResponseEntity.ok(map);
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserVO userVO) {
        System.out.println("这是uservo"+userVO);
        String encode = passwordEncoder.encode(userVO.getPassword());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        userVO.setPassword(encode);
        userVO.setCreated(timestamp);
        userService.addUser(userVO);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserVO userVO) {
        System.out.println("这是uservo"+userVO.getImg());
        String encode = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encode);
        userService.updateUser(userVO);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/banUser")
    public ResponseEntity<?> banUser(@RequestBody UserVO userVO) {
        userService.banUser(userVO);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用任务
    @GetMapping(value = "/banUserRows")
    public ResponseEntity<?> banUserRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        userService.banUserRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/checkPhone")
    public ResponseEntity<?> checkPhone(@RequestParam("id") int id,@RequestParam("phone") String phone) {
        System.out.println("这是id" + id+"这是phone"+phone);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("phone",phone);
        UserVO userVO = userService.checkPhone(map);
        return ResponseEntity.ok(userVO);
    }
    @PostMapping(value = "/changePwd")
    public ResponseEntity<?> changePwd(@RequestBody UserVO userVO) {
        String encode = passwordEncoder.encode(userVO.getPassword());
        userVO.setPassword(encode);
        userService.changePwd(userVO);
        return ResponseEntity.ok("操作成功");
    }
    @GetMapping(value = "/findUserByID")
    public ResponseEntity<?> findUserByID(@RequestParam("id") int id) {
        UserVO userVO=userService.findUserByID(id);
//        System.out.println("uservo" +userVO);
        return ResponseEntity.ok(userVO);
    }
    //前台修改个人资料
    @PostMapping(value = "/changeUserData")
    public ResponseEntity<?> changeUserData(@RequestBody UserVO userVO) {
        System.out.println(userVO.getImg());
        userService.changeUserData(userVO);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/findRolesByUid")
    public ResponseEntity<?> findRolesByUid(@RequestParam("userId") int userId) {
        List<RoleVO> list=userService.findRolesByUid(userId);
        System.out.println("list" +list);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/updateRoles")
    public ResponseEntity<?> updateRoles(@RequestParam("ids") String ids,@RequestParam("userId") int userId) {
        List<String> list = Arrays.asList(ids.split(","));
        System.out.println("这是ids"+list+"这是uid"+userId);
        int i = userService.deleteAll(userId);
        userService.updateRoles(list,userId);


        return ResponseEntity.ok("操作成功");
    }
}
