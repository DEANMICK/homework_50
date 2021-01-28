package com.example.demo.Repository;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {
    Comment findCommentById(Integer id);
    void deleteCommentByUserId(User user, Integer id);

    List<Comment> findCommentByUser(User user);
}
