package com.example.twitter.user.tweet.service;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(long tweetId);

    void deleteTweet(long id);

    Collection<Tweet> findAllTweets(UserProfile owner, Pageable pageable);
}
