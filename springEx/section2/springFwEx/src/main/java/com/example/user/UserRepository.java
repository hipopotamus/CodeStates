package com.example.user;

public interface UserRepository {
    void saveUser(User user);

    User findByUserId(Long userId);
}
