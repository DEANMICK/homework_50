package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findAuthorById(int i);
    User findUserById(int j);
    User findUserByName(String name);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User save(User user);
    List<User> findAll();
    void deleteUser(User user);
    boolean existsByEmail(String mail);
    boolean checkUserByLoginAndAndPassword(String username, String password);
}
