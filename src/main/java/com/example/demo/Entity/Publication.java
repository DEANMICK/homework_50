package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "publications")
public class Publication extends Main{

    @Column(name = "author")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(name = "image")
    private String source;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;
}
