package com.example.demo.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Comment() {
    }

    public Comment(String text, User user) {
        this.user = user;
        this.text = text;
    }
}
