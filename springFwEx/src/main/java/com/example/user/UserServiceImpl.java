package com.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signup(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
