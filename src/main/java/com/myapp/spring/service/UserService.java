package com.myapp.spring.service;

import com.myapp.spring.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
