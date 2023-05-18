package com.example.springboot_demo.Dao;

import com.example.springboot_demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectUserByUsername(String username);
    void insertNewUser(User user);
    User selectUserByEmail(String email);
    void updateUserByUsername(String username, String password, String email);
}
