package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
