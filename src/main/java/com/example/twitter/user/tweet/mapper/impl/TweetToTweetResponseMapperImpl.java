package com.example.twitter.user.tweet.mapper.impl;

import com.example.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet model) {
        return new TweetResponse(
                model.getId(),
                model.getMessage(),
                model.getCreatedTimestamp()
                );
    }
}
