package com.example.twitter.user.tweet.usecase;

import com.example.twitter.user.tweet.web.model.TweetFindRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
@Validated
public interface TweetFindUseCase {
     Collection<TweetResponse> findTweets(@Valid TweetFindRequest findRequest);
}
