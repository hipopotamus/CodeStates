package com.example.user;

import org.springframework.stereotype.Component;

public interface UserService {
    void signup(User user);

    User findUser(Long userId);
}
