package com.example.twitter.user.tweet.usecase;

import com.example.twitter.user.tweet.web.model.TweetAddRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;

public interface TweetAddUseCase {
    TweetResponse addTweet(TweetAddRequest addRequest);
}
