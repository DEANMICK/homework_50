package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "users")
public class User {
    @Id
    private Integer id;

    @Indexed
    private String username;

    @Indexed
    private String email;

    private String password;

    @DBRef
    private List<Publication> publication = new ArrayList<>();

    @DBRef
    private List<User> subscription = new ArrayList<>();

    @DBRef
    private List<User> subscriber = new ArrayList<>();

    private LocalDateTime date;
}
