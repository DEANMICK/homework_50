package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Поле 'username' не может быть пустым")
    @Column(name = "username")
    private String username;

    @Email(message = "Email неверный")
    @NotBlank(message = "Поле 'Email' не может быть пустым")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Поле 'Password' не может быть пустым")
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Publication> publication;

    @Column(name = "subscriptions")
    @ManyToMany
    @JoinTable(name = "subscriptions", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "subscriber_id")})
    private List<User> subscription;

    @Column(name = "subscribers")
    @ManyToMany
    @JoinTable(name = "subscribers", joinColumns = {@JoinColumn(name = "subscriber_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> subscriber;

    @Column(name = "date")
    private LocalDateTime date;
}
