package com.example.twitter.user.tweet.usecase.impl;

import com.example.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import com.example.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.service.TweetService;
import com.example.twitter.user.tweet.usecase.TweetAddUseCase;
import com.example.twitter.user.tweet.web.model.TweetAddRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetAddUseCaseFacade implements TweetAddUseCase {
    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    public TweetAddUseCaseFacade(TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper, TweetToTweetResponseMapper tweetToTweetResponseMapper, TweetService tweetService) {
        this.tweetAddRequestToTweetMapper = tweetAddRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetService = tweetService;
    }

    @Override
    public TweetResponse addTweet(TweetAddRequest addRequest) {
        Tweet mappedTweet = tweetAddRequestToTweetMapper.map(addRequest);
        Tweet createdTweet = tweetService.createTweet(mappedTweet);


        return tweetToTweetResponseMapper.map(createdTweet);
    }
}
