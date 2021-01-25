package com.example.demo.Service;

import com.example.demo.Repository.LikeRepository;
import com.example.demo.Repository.PublicationRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    private UserRepository userRepository;
    private PublicationRepository publicationRepository;

    public boolean findLike(Integer userId, Integer publicationId) {
        return likeRepository.existsLikeByUserAndPublication(userRepository.findUserById(userId), publicationRepository.findPublicationById(publicationId));
    }
}
