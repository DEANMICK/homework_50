package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
//    1) Поиск user по username
//    2) Поиск user по email
//    3) Save User
//    4) Delete User
//    5) Update User
}
