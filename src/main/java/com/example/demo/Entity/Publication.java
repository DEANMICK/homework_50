package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "publications")
public class Publication extends Main{
    @Column(name = "image")
    private String source;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;
}
