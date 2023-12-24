package com.example.twitter.user.subscribtion.usecase.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.mapper.UnsubscribeRequestToSubscriptionMapper;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.service.SubscriptionService;
import com.example.twitter.user.subscribtion.usecase.SubscriptionDeleteUseCase;
import com.example.twitter.user.subscribtion.web.model.UnsubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseImpl implements SubscriptionDeleteUseCase {
    private final SubscriptionService subscriptionService;
    private final UnsubscribeRequestToSubscriptionMapper unsubscribeRequestToSubscriptionMapper;

    public SubscriptionDeleteUseCaseImpl(SubscriptionService subscriptionService, UnsubscribeRequestToSubscriptionMapper unsubscribeRequestToSubscriptionMapper) {
        this.subscriptionService = subscriptionService;
        this.unsubscribeRequestToSubscriptionMapper = unsubscribeRequestToSubscriptionMapper;
    }

    @Override
    public void unsubscribe(UnsubscribeRequest unsubscribeRequest) throws TwitterException {
        Subscription subscription = unsubscribeRequestToSubscriptionMapper.map(unsubscribeRequest);

        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if(follower.equals(followed)){
            throw new TwitterException("Отписка от самого себя не имеет смысла");

        }

        if(!subscriptionService.existSubscription(subscription)){
            String errorMessage = String.format(
                    "Вы не были подписаны на %s",
                    followed.getNickname()
            );
            throw new TwitterException(errorMessage);
        }
        subscriptionService.deleteSubscription(subscription);


    }
}
