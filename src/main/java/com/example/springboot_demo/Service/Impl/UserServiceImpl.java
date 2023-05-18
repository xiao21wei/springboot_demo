package com.example.springboot_demo.Service.Impl;

import com.example.springboot_demo.Dao.UserDao;
import com.example.springboot_demo.Entity.User;
import com.example.springboot_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
    @Override
    public void insertNewUser(User user) {
        userDao.insertNewUser(user);
    }
    @Override
    public User selectUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }
    @Override
    public void updateUserByUsername(String username, String password, String email) {
        userDao.updateUserByUsername(username, password, email);
    }
}
