package com.example.demo.Repository;

import com.example.demo.Entity.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber, Integer> {
    List<Subscriber> findSubscriberById(int i);
}
