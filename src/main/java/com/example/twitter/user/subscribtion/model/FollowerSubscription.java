package com.example.twitter.user.subscribtion.model;

import com.example.twitter.user.profile.model.UserProfile;

import java.time.Instant;

public interface FollowerSubscription {
    long getId();
    UserProfile getFollower();
    Instant getCreatedTimestamp();

}
