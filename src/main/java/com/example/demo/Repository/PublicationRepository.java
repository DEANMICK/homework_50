package com.example.demo.Repository;

import com.example.demo.Entity.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends MongoRepository<Publication, Integer> {
    List<Publication> findPublicationById(int i);
}
