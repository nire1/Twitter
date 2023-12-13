package com.example.twitter.user.tweet.mapper;

import com.example.twitter.security.mapper.Mapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.web.model.TweetResponse;

public interface TweetToTweetResponseMapper extends Mapper<TweetResponse, Tweet> {
}
