package com.example.twitter.user.tweet.mapper;

import com.example.twitter.security.mapper.Mapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;

public interface TweetPageToTweetPageResponseMapper extends Mapper<TweetPageResponse, Page<Tweet>> {
}
