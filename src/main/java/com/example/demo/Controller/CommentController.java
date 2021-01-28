package com.example.demo.Controller;

import com.example.demo.DTO.CommentDTO;
import com.example.demo.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/{id}")
    public CommentDTO addComment(@PathVariable("id") Integer id, @RequestParam("publicationId") Integer publicationId,
                                 @RequestParam("text") String text) {
        return CommentDTO.getComment(commentService.addComment(id, publicationId, text));
    }

    @DeleteMapping("/comment/delete/{id}")
    public List<CommentDTO> deleteComment(@PathVariable("id") Integer id, @RequestParam("commentId") Integer commentId) {
        return CommentDTO.getListComment(commentService.deleteCommentByUserId(id, commentId));
    }
}