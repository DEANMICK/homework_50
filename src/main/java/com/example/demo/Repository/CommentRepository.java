package com.example.demo.Repository;

import com.example.demo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    1) Просмотри всех user оставивших комментарий
//    2) Поиск user по комментарию
//    3) Save Comment
//    4) Delete Comment
//    5) Update Comment
}
