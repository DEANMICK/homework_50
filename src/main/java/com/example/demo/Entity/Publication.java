package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "publications")
public class Publication{

    @Id
    private Integer id;

    @DBRef
    private User author;

    private String source;

    private String description;

    private LocalDateTime date;
}
