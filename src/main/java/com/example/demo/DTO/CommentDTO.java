package com.example.demo.DTO;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
public class CommentDTO {
    private final Integer id;
    private final String text;
    private final User user;
    private final Publication publication;

    public static CommentDTO getComment(Comment comment) {
        return CommentDTO.builder()
                .user(comment.getUser())
                .publication(comment.getPublication())
                .text(comment.getText())
                .build();
    }

    public static List<CommentDTO> getListComment(List<Comment> comments) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment: comments) {
            commentDTOS.add(getComment(comment));
        }
        return commentDTOS;
    }
}
