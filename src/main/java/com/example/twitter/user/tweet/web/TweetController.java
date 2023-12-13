package com.example.twitter.user.tweet.web;

import com.example.twitter.user.tweet.usecase.TweetAddUseCase;
import com.example.twitter.user.tweet.usecase.TweetEditUseCase;
import com.example.twitter.user.tweet.web.model.TweetAddRequest;
import com.example.twitter.user.tweet.web.model.TweetEditRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;



    public TweetController(TweetAddUseCase tweetAddUseCase,TweetEditUseCase tweetEditUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
        this.tweetEditUseCase = tweetEditUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest){
        return tweetAddUseCase.addTweet(addRequest);
    }

    @PutMapping
    public TweetResponse editTweet(@Valid @RequestBody TweetEditRequest editRequest){
        return tweetEditUseCase.editTweet(editRequest);
    }
}
