package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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

    @Column(name = "publication_id")
    @OneToMany(mappedBy = "publications", cascade = CascadeType.ALL)
    private List<Publication> publication;

    @Column(name = "subscription_id")
    @ManyToMany(mappedBy = "subscriptions", cascade = CascadeType.ALL)
    private List<Subscription> subscription;

    @Column(name = "subscribers_id")
    @ManyToMany(mappedBy = "subscribers", cascade = CascadeType.ALL)
    private List<Subscribers> subscriber;
}
