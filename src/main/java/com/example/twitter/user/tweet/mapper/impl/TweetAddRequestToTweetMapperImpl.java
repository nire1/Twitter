package com.example.twitter.user.tweet.mapper.impl;

import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.web.model.TweetAddRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetAddRequestToTweetMapperImpl(CurrentUserProfileApiService currentUserProfileApiService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public Tweet map(TweetAddRequest request) {
        Tweet tweet = new Tweet();
        tweet.setUserProfile(currentUserProfileApiService.currentUserProfile());
        tweet.setMessage(request.message());
        return tweet;
    }
}
