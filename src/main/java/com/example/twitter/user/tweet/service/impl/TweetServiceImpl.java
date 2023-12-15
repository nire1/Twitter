package com.example.twitter.user.tweet.service.impl;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.repository.TweetRepository;
import com.example.twitter.user.tweet.service.TweetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Optional<Tweet> findTweetById(long tweetId) {
        return tweetRepository.findById(tweetId);
    }

    @Override
    public Collection<Tweet> findAllTweets(UserProfile owner) {
        return tweetRepository.findAllByUserProfile(owner);
    }

    @Override
    public void deleteTweet(long id) {
        tweetRepository.deleteById(id);
    }
}

