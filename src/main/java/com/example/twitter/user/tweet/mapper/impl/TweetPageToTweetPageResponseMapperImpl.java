package com.example.twitter.user.tweet.mapper.impl;

import com.example.twitter.user.tweet.mapper.TweetPageToTweetPageResponseMapper;
import com.example.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.web.model.TweetPageResponse;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TweetPageToTweetPageResponseMapperImpl implements TweetPageToTweetPageResponseMapper {

    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetPageToTweetPageResponseMapperImpl(TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public TweetPageResponse map(Page<Tweet> source) {
        Collection<TweetResponse> tweetPageResponse = source
                .stream()
                .map(tweetToTweetResponseMapper::map)
                .toList();
        return new TweetPageResponse(source.getTotalElements()
                ,source.isFirst()
                ,source.isLast()
                ,tweetPageResponse);
    }
}
