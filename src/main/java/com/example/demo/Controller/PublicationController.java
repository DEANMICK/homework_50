package com.example.demo.Controller;

import com.example.demo.DTO.PublicationDTO;
import com.example.demo.Service.PublicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    @GetMapping("/feedForUser")
    public List<PublicationDTO> feedUser(@RequestParam("id") String id) {
        return PublicationDTO.getListPublication(publicationService.feedForUser(id));
    }
}