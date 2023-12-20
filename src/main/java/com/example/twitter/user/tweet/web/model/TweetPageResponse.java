package com.example.twitter.user.tweet.web.model;

import com.example.twitter.user.tweet.mapper.impl.TweetToTweetResponseMapperImpl;

import java.util.Collection;

public record TweetPageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,


        Collection<TweetResponse> collection) {
}
