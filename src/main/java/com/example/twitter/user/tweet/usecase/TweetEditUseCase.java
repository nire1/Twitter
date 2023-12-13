package com.example.twitter.user.tweet.usecase;

import com.example.twitter.user.tweet.web.model.TweetEditRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest editRequest);
}
