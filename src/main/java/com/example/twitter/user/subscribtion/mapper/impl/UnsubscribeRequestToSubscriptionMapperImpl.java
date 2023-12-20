package com.example.twitter.user.subscribtion.mapper.impl;

import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.api.service.UserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.mapper.UnsubscribeRequestToSubscriptionMapper;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.web.model.UnsubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class UnsubscribeRequestToSubscriptionMapperImpl implements UnsubscribeRequestToSubscriptionMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;

    public UnsubscribeRequestToSubscriptionMapperImpl(CurrentUserProfileApiService currentUserProfileApiService, UserProfileApiService userProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.userProfileApiService = userProfileApiService;
    }


    @Override
    public Subscription map(UnsubscribeRequest unsubscribeRequest) {
        UserProfile follower = currentUserProfileApiService
                .currentUserProfile();

        UserProfile followed = userProfileApiService.findUserProfileById(unsubscribeRequest.followedId());

        Subscription subscription = new Subscription();
        subscription.setFollower(follower);
        subscription.setFollowed(followed);
        return subscription;
    }
}
