package com.example.twitter.user.subscribtion.service;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.model.FollowerSubscription;
import com.example.twitter.user.subscribtion.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public interface SubscriptionService {

    void deleteSubscription(Subscription subscription);
    boolean existSubscription(Subscription subscription);

    void createSubscription(Subscription subscription);

    Page<FollowerSubscription> findAllFollowerSubscriptions(UserProfile author, Pageable pageable);
}
