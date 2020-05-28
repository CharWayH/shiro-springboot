package com.charwayh.shirospringboot.service;

import com.charwayh.shirospringboot.mapper.UserMapper;
import com.charwayh.shirospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper = null;

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
