package com.example.twitter.user.subscribtion.service;

import com.example.twitter.user.subscribtion.model.Subscription;


public interface SubscriptionService {

    void deleteSubscription(Subscription subscription);
    boolean existSubscription(Subscription subscription);

    void createSubscription(Subscription subscription);
}
