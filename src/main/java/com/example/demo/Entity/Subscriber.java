package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "subscribers")
public class Subscriber {
    @Id
    private Integer id;

    @DBRef
    private User user;
}
