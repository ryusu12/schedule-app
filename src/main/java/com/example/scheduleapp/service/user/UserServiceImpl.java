package com.example.scheduleapp.service.user;

import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //생성
    @Transactional
    @Override
    public User saveUser(String name, String email) {
        User user = userRepository.findUserByNameAndEmailOrElseThrow(name, email);
        // 같은 name과 email을 가진 작성자가 있으면 리턴
        if (user != null) {
            return user;
        }
        // 없으면 생성
        return userRepository.saveUser(new User(name, email));
    }
}