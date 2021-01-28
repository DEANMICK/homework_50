package com.example.demo.Service;

import com.example.demo.Entity.Comment;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.PublicationRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public Comment addComment(Integer userId, Integer publicationId, String comment) {
        Comment comment1 = Comment.builder()
                .id(commentRepository.findAll().size() + 1)
                .user(userRepository.findUserById(userId))
                .publication(publicationRepository.findPublicationById(publicationId))
                .text(comment)
                .build();
        commentRepository.save(comment1);
        return commentRepository.findCommentById(comment1.getId());
    }

    public List<Comment> deleteCommentByUserId(Integer userId, Integer commentId) {
        if (userId.equals(commentRepository.findCommentById(commentId).getPublication().getUser().getId())) {
            commentRepository.deleteCommentByUserId(userRepository.findUserById(userId), commentId);
        }
        return commentRepository.findCommentByUser(userRepository.findUserById(userId));
    }
}
