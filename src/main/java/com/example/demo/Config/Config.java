package com.example.demo.Config;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@Configuration
public class Config {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriberRepository subscriberRepository;
    private final CommentRepository commentRepository;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return (args) -> {
            users().forEach(userRepository::save);
            publications().forEach(publicationRepository::save);
            comments().forEach(commentRepository::save);
            subscribers().forEach(subscriberRepository::save);
            subscriptions().forEach(subscriptionRepository::save);
        };
    }

    private List<Subscription> subscriptions() {
        return List.of(
                Subscription.builder().id(1)
                .user(userRepository.findUserById(1))
                .build()
        );
    }

    private List<Subscriber> subscribers() {
        return List.of(
                Subscriber.builder().id(1)
                .user(userRepository.findUserById(1))
                .build()
        );
    }

    private List<Comment> comments() {
        return List.of(
                Comment.builder().id(1)
                .user(userRepository.findUserById(1))
                .text("Like")
                .build()
        );
    }

    private List<Publication> publications() {
        return List.of(
                Publication.builder().id(1)
                .user(userRepository.findAuthorById(1))
                .source("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.britannica.com%2Fbiography%2FVincent-van-Gogh&psig=AOvVaw3wYOubtuNmzCm6IfTzZG6K&ust=1611311863843000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKjN_9_BrO4CFQAAAAAdAAAAABAD")
                .description("this is photo")
                .date(LocalDateTime.now())
                .build()
        );
    }

    private List<User> users() {
        return List.of(
                User.builder().id(1)
                .username("Dean")
                .email("dean@mail.com")
                .password("qwerty123")
                .publication(publicationRepository.findPublicationById(1))
                .subscriber(subscriberRepository.findSubscriberById(1))
                .subscription(subscriptionRepository.findSubscriptionById(1))
                .date(LocalDateTime.now())
                .build()
        );
    }
}
