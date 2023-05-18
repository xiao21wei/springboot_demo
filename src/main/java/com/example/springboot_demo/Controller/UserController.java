package com.example.springboot_demo.Controller;

import com.example.springboot_demo.Entity.User;
import com.example.springboot_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> Register(@RequestBody Map<String, Object> re_map){
        String username = (String) re_map.get("username");
        String password = (String) re_map.get("password");
        String email = (String) re_map.get("email");
        Map<String, Object> map = new HashMap<>();

        try {
            User user1 = userService.selectUserByUsername(username);
            if (user1 != null){
                map.put("code", 400);
                map.put("msg", "用户名已存在");
                return map;
            }
            User user = new User(username, password, email);
            userService.insertNewUser(user);
            map.put("code", 200);
            map.put("msg", "用户注册成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "用户注册失败");
            return map;
        }
    }

    @PostMapping("/login")
    public Map<String, Object> Login(@RequestBody Map<String, Object> re_map){
        String username = (String) re_map.get("username");
        String password = (String) re_map.get("password");
        Map<String, Object> map = new HashMap<>();

        try {
            User user = userService.selectUserByUsername(username);
            if (user == null){
                map.put("code", 400);
                map.put("msg", "用户名不存在");
                return map;
            }
            if (!user.getPassword().equals(password)){
                map.put("code", 400);
                map.put("msg", "密码错误");
                return map;
            }

            map.put("code", 200);
            map.put("msg", "登录成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "登录失败");
            return map;
        }
    }

    @PostMapping("/update")
    public Map<String, Object> Update(@RequestBody Map<String, Object> re_map){
        String username = (String) re_map.get("username");
        String password = (String) re_map.get("password");
        String email = (String) re_map.get("email");
        Map<String, Object> map = new HashMap<>();

        try {
            User user = userService.selectUserByUsername(username);
            if (user == null){
                map.put("code", 400);
                map.put("msg", "用户名不存在");
                return map;
            }
            userService.updateUserByUsername(username, password, email);
            map.put("code", 200);
            map.put("msg", "修改成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "修改失败");
            return map;
        }
    }

    @PostMapping("/logout")
    public Map<String, Object> Logout(@RequestBody Map<String, Object> re_map){
        String username = (String) re_map.get("username");
        Map<String, Object> map = new HashMap<>();

        try {
            User user = userService.selectUserByUsername(username);
            if (user == null){
                map.put("code", 400);
                map.put("msg", "用户名不存在");
                return map;
            }
            map.put("code", 200);
            map.put("msg", "注销成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "注销失败");
            return map;
        }
    }

    @PostMapping("/get_user")
    public Map<String, Object> GetUser(@RequestBody Map<String, Object> re_map){
        String username = (String) re_map.get("username");
        Map<String, Object> map = new HashMap<>();

        try {
            User user = userService.selectUserByUsername(username);
            if (user == null){
                map.put("code", 400);
                map.put("msg", "用户名不存在");
                return map;
            }
            map.put("code", 200);
            map.put("msg", "获取成功");
            map.put("data", user);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "获取失败");
            return map;
        }
    }
}


