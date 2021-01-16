package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subscribers")
public class Subscribers extends Main{

}
