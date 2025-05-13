package com.example.scheduleapp.service.user;

import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //생성
    @Override
    public User saveUser(String name, String email) {
        if (name == null || email == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name, email are required values.");
        }
        User user = new User(name, email);
        return userRepository.saveUser(user);
    }
}