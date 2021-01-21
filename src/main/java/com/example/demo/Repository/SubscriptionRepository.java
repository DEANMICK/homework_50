package com.example.demo.Repository;

import com.example.demo.Entity.Subscription;
import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Integer> {
    List<Subscription> findSubscriptionById(int i);
}
