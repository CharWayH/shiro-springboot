package com.charwayh.shirospringboot.service;

import com.charwayh.shirospringboot.pojo.User;

public interface UserService {
     User queryUserByName(String username);
}
