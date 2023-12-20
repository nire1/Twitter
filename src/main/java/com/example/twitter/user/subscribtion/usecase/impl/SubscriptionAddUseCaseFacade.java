package com.example.twitter.user.subscribtion.usecase.impl;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.mapper.SubscribeRequestToSubscriptionMapper;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.service.SubscriptionService;
import com.example.twitter.user.subscribtion.usecase.SubscriptionAddUseCase;
import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {
    private final SubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionAddUseCaseFacade(SubscribeRequestToSubscriptionMapper subscriptionMapper, SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = subscriptionMapper.map(subscribeRequest);
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (subscription.getFollower().equals(subscription.getFollowed())){
            throw  new RuntimeException("Вы не можете подписаться сами на себя");
        }

        if(subscriptionService.existSubscription(subscription)){
            String errorMessage = String.format(
                    "Вы уже подписаны на %s",
                    followed.getNickname()
            );
            throw new RuntimeException(errorMessage);
        }
        subscriptionService.createSubscription(subscription);


    }
}
