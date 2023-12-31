package com.example.twitter.user.subscribtion.usecase;

import com.example.twitter.user.subscribtion.web.model.FollowerFindRequest;
import com.example.twitter.user.subscribtion.web.model.FollowerPageResponse;
import com.example.twitter.user.subscribtion.web.model.FollowerResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
@Validated
public interface SubscriptionFindFollowersUseCase {
    FollowerPageResponse findFollowers(@Valid FollowerFindRequest findRequest);
}
