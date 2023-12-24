package com.example.twitter.user.tweet.usecase.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.service.TweetService;
import com.example.twitter.user.tweet.usecase.TweetDeleteUseCase;
import org.springframework.stereotype.Component;

@Component
public class TweetDeleteUseCaseFacade implements TweetDeleteUseCase {
    private CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    public TweetDeleteUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService, TweetService tweetService) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetService = tweetService;
    }

    @Override
    public void deleteTweet(long tweetId) {

        UserProfile actor = currentUserProfileApiService.currentUserProfile();

        UserProfile owner = tweetService
                .findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не существует",tweetId);
                    return new TwitterException(errorMessage);
                });
        if(!actor.equals(owner)){
            String errorMessage = String.format("Удаление твита с id = %d запрещено. Пользователь %s не является его владельцем",
                    tweetId,
                    actor.getNickname()
            );
            throw new TwitterException(errorMessage);
        }
        tweetService.deleteTweet(tweetId);
    }
    }
