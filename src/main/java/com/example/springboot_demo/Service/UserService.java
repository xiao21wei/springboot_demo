package com.example.springboot_demo.Service;

import com.example.springboot_demo.Entity.User;

public interface UserService {
    User selectUserByUsername(String username);
    void insertNewUser(User user);
    User selectUserByEmail(String email);
    void updateUserByUsername(String username, String password, String email);
}
