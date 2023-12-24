package com.example.twitter.user.tweet.mapper.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.service.TweetService;
import com.example.twitter.user.tweet.web.model.TweetEditRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {

    private final TweetService tweetService;

    public TweetEditRequestToTweetMapperImpl(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public Tweet map(TweetEditRequest request) {
        Tweet currentTweet = tweetService
                .findTweetById(request.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не существует", request.id());
                    return new TwitterException(errorMessage);
                });
        currentTweet.setMessage(request.message());

        return currentTweet;
    }
}
