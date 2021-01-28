package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public boolean findExistByMail(String mail) {
        return userRepository.existsByEmail(mail);
    }

    public User saveUser(String username, String email, String password) {
        User user = User.builder()
                .id(userRepository.findAll().size() + 1)
                .username(username)
                .email(email)
                .password(password)
                .build();
        userRepository.save(user);
        return userRepository.findUserById(user.getId());
    }

    public User login(String username, String password) {
        if (userRepository.checkUserByLoginAndAndPassword(username, password)) {
            return userRepository.findUserByUsername(username);
        } throw new IllegalArgumentException();
    }
}
