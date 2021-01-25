package com.example.demo.Service;

import com.example.demo.Entity.Publication;
import com.example.demo.Entity.Subscription;
import com.example.demo.Repository.PublicationRepository;
import com.example.demo.Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    private SubscriptionRepository subscriptionRepository;

    public Iterable<Publication> findAllOtherPublications(Integer id) {
        return publicationRepository.findUserPublicationById(id);
    }

    public List<Publication> feedForUser(String userId) {
        List<Publication> publications = new ArrayList<>();
        for (Subscription f : subscriptionRepository.findAll()) {
            if (f.getUser().getId().equals(userId)) {
                for (Publication p : publicationRepository.findAll()) {
                    if (p.getUser().getId().equals(f.getUser().getId())) {
                        publications.add(p);
                    }
                }
            }
        }
        return publications;
    }
}
