package com.example.twitter.user.tweet.usecase;

import com.example.twitter.user.tweet.web.model.TweetResponse;

import java.util.Collection;

public interface TweetFindUseCase {
     Collection<TweetResponse> findTweets();
}
