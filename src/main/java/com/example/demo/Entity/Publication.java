package com.example.demo.Entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "publications")
public class Publication{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @Column(name = "image")
    private String source;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;

    public Publication() {
    }

    public Publication(String source, String description, LocalDateTime date) {
        this.source = source;
        this.description = description;
        this.date = date;
    }
}
