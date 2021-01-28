package com.example.demo.DTO;

import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
public class PublicationDTO {
    private final User user;
    private final String source;
    private final String description;
    private final LocalDateTime date;

    public static PublicationDTO getPublication(Publication publication) {
        return PublicationDTO.builder()
                .user(publication.getUser())
                .source(publication.getSource())
                .description(publication.getDescription())
                .date(publication.getDate())
                .build();
    }

    public static List<PublicationDTO> getListPublication(List<Publication> publications) {
        List<PublicationDTO> publicationDTOS = new ArrayList<>();
        for (Publication publication: publications) {
            publicationDTOS.add(PublicationDTO.getPublication(publication));
        }
        return publicationDTOS;
    }
}
