package com.example.demo.Config;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Like;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import com.example.demo.Utils.Generator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    CommandLineRunner fullFillDB() {
        List<User> userList = userList();
        makePublications(userList);
    }

    private List<User> userList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            users.add(new User(Generator.makeName(), Generator.makeEmail(), Generator.makePassword()));
        }
        return users;
    }

    private void makePublications(List<User> userList) {
        userList.forEach(o -> o.getPublication().add(new Publication(Generator.makeName(), Generator.makeDescription(), new LocalDateTime())));
    }
}
