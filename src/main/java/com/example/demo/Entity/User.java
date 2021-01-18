package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends Main {
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "publications", cascade = CascadeType.ALL)
    private List<Publication> publication;

    @ManyToMany
    @JoinTable(name = "subscriptions", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "subscriber_id")})
    private List<Subscription> subscription;

    @ManyToMany
    @JoinTable(name = "subscribers", joinColumns = {@JoinColumn(name = "subscriber_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<Subscribers> subscriber;

    @Column(name = "date")
    private LocalDateTime date;
}
