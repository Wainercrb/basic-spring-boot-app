package com.crss.basicspringboot.service;

import com.crss.basicspringboot.entity.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    User saveUser(User user);
}