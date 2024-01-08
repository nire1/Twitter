package com.example.twitter.user.tweet.usecase;

import com.example.twitter.user.tweet.web.model.TweetFindRequest;
import com.example.twitter.user.tweet.web.model.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;


@Validated
public interface TweetFindUseCase {
     TweetPageResponse findTweets(@Valid TweetFindRequest findRequest);
}
