package com.example.twitter.user.subscribtion.mapper.impl;

import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.api.service.UserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.mapper.SubscribeRequestToSubscriptionMapper;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscribeRequestToSubscriptionMapperImpl implements SubscribeRequestToSubscriptionMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;

    public SubscribeRequestToSubscriptionMapperImpl(CurrentUserProfileApiService currentUserProfileApiService, UserProfileApiService userProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.userProfileApiService = userProfileApiService;
    }

    @Override
    public Subscription map(SubscribeRequest subscribeRequest) {

        UserProfile follower = currentUserProfileApiService
                .currentUserProfile();

        UserProfile followed = userProfileApiService.findUserProfileById(subscribeRequest.followedId());

        Subscription subscription = new Subscription();
        subscription.setFollower(follower);
        subscription.setFollowed(followed);
        return subscription;
    }
}
