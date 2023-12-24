package com.example.twitter.user.tweet.usecase.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.example.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.service.TweetService;
import com.example.twitter.user.tweet.usecase.TweetEditUseCase;
import com.example.twitter.user.tweet.web.model.TweetEditRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetEditUseCaseImpl implements TweetEditUseCase {
    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    private final CurrentUserProfileApiService currentUserProfileApiService;


    public TweetEditUseCaseImpl(TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper, TweetToTweetResponseMapper tweetToTweetResponseMapper, TweetService tweetService, CurrentUserProfileApiService currentUserProfileApiService) {
        this.tweetEditRequestToTweetMapper = tweetEditRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetService = tweetService;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public TweetResponse editTweet(TweetEditRequest editRequest) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();

        UserProfile owner = tweetService
                .findTweetById(editRequest.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Твит с id = %d не существует", editRequest.id());
                    return new TwitterException(errorMessage);
                });

        if(!actor.equals(owner)){
            String errorMessage = String.format("Редактирование твита с id = %d запрещено. Пользователь %s не является его владельцем",
                    editRequest.id(),
                    actor.getNickname()
            );
            throw new TwitterException(errorMessage);
        }
        Tweet tweet = tweetEditRequestToTweetMapper.map(editRequest);
        Tweet updatedTweet = tweetService.updateTweet(tweet);

        return tweetToTweetResponseMapper.map(updatedTweet);
    }
}
