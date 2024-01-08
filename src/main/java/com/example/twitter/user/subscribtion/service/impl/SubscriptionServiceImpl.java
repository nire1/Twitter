package com.example.twitter.user.subscribtion.service.impl;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.model.FollowerSubscription;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.repository.SubscriptionRepository;
import com.example.twitter.user.subscribtion.service.SubscriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void deleteSubscription(Subscription subscription) {

        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        subscriptionRepository
                .findByFollowerAndFollowed(follower,followed)
                .ifPresent(subscriptionRepository::delete);
    }

    @Override
    public boolean existSubscription(Subscription subscription) {
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();
        return subscriptionRepository
                .existsByFollowerAndFollowed(follower,followed);
    }

    @Override
    public void createSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);

    }

    @Override
    public Page<FollowerSubscription> findAllFollowerSubscriptions(UserProfile author, Pageable pageable) {
        return subscriptionRepository.findAllByFollowed(author,pageable);
    }


}

