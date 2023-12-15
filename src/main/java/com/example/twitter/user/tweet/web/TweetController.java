package com.example.twitter.user.tweet.web;

import com.example.twitter.user.tweet.usecase.TweetAddUseCase;
import com.example.twitter.user.tweet.usecase.TweetDeleteUseCase;
import com.example.twitter.user.tweet.usecase.TweetEditUseCase;
import com.example.twitter.user.tweet.usecase.TweetFindUseCase;
import com.example.twitter.user.tweet.web.model.TweetAddRequest;
import com.example.twitter.user.tweet.web.model.TweetEditRequest;
import com.example.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;

    private final TweetDeleteUseCase tweetDeleteUseCase;

    private final TweetFindUseCase tweetFindUseCase;



    public TweetController(TweetAddUseCase tweetAddUseCase, TweetEditUseCase tweetEditUseCase, TweetDeleteUseCase tweetDeleteUseCase, TweetFindUseCase tweetFindUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
        this.tweetEditUseCase = tweetEditUseCase;

        this.tweetDeleteUseCase = tweetDeleteUseCase;
        this.tweetFindUseCase = tweetFindUseCase;
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

    @DeleteMapping("/{tweetId}")
    public void deleteTweet(@PathVariable long tweetId){
        tweetDeleteUseCase.deleteTweet(tweetId);
    }
    @GetMapping
    public Collection<TweetResponse> findOwnerTweets(){
        return tweetFindUseCase.findTweets();
    }
}
