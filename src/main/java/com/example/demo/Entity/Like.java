package com.example.demo.Entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "likes")
public class Like{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "publication_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Publication publication;

    @Column(name = "date")
    private LocalDateTime date;
}
