package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findAuthorById(int i);
    User findUserById(int j);
    User findUserByName(String name);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    boolean existsByEmail(String mail);
}
