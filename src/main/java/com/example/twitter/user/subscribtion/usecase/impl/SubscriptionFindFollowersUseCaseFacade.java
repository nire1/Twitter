package com.example.twitter.user.subscribtion.usecase.impl;

import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.model.FollowerSubscription;
import com.example.twitter.user.subscribtion.model.Subscription_;
import com.example.twitter.user.subscribtion.service.SubscriptionService;
import com.example.twitter.user.subscribtion.usecase.SubscriptionFindFollowersUseCase;
import com.example.twitter.user.subscribtion.web.model.FollowerFindRequest;
import com.example.twitter.user.subscribtion.web.model.FollowerPageResponse;
import com.example.twitter.user.subscribtion.web.model.FollowerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionFindFollowersUseCaseFacade implements SubscriptionFindFollowersUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final SubscriptionService subscriptionService;

    public SubscriptionFindFollowersUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService, SubscriptionService subscriptionService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public FollowerPageResponse findFollowers(FollowerFindRequest findRequest) {
        UserProfile author = currentUserProfileApiService.currentUserProfile();

        Pageable pageable = PageRequest
                .of(
                        findRequest.page(),
                        findRequest.limit(),
                        Sort.by(
                                Sort.Direction.DESC,
                                Subscription_.CREATED_TIMESTAMP
                        )
                );

        Page<FollowerSubscription> subscriptions = subscriptionService.findAllFollowerSubscriptions(author,pageable);

        List<FollowerResponse> followers = subscriptions.stream().map(item ->
                new FollowerResponse(
                        item.getId(),
                        item.getFollower().getId(),
                        item.getFollower().getNickname(),
                        item.getFollower().getImageLink(),
                        item.getCreatedTimestamp()
                )
        ).toList();
    return new FollowerPageResponse(
            subscriptions.getTotalElements(),
            subscriptions.isFirst(),
            subscriptions.isLast(),
            followers
    );
    }
}
