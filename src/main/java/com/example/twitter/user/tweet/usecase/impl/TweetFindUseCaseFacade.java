package com.example.twitter.user.tweet.usecase.impl;

import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitter.user.tweet.model.Tweet;
import com.example.twitter.user.tweet.repository.TweetRepository;
import com.example.twitter.user.tweet.service.TweetService;
import com.example.twitter.user.tweet.usecase.TweetFindUseCase;
import com.example.twitter.user.tweet.web.model.TweetFindRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.example.twitter.user.tweet.model.Tweet_.CREATED_TIMESTAMP;

@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetRepository tweetRepository;


    public TweetFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService, TweetService tweetService, TweetToTweetResponseMapper tweetToTweetResponseMapper,
                                  TweetRepository tweetRepository) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.tweetService = tweetService;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Collection<TweetResponse> findTweets(TweetFindRequest findRequest) {
        UserProfile owner = currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC,CREATED_TIMESTAMP
        );

        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(),sort);

        Collection<Tweet> allOwnerTweets = tweetService.findAllTweets(owner,pageable);
        return allOwnerTweets
                .stream()
                .map(tweetToTweetResponseMapper::map)
                .toList();
    }
}
