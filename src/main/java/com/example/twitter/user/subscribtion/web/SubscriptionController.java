package com.example.twitter.user.subscribtion.web;

import com.example.twitter.user.subscribtion.usecase.SubscriptionAddUseCase;
import com.example.twitter.user.subscribtion.usecase.SubscriptionDeleteUseCase;
import com.example.twitter.user.subscribtion.usecase.SubscriptionFindFollowersUseCase;
import com.example.twitter.user.subscribtion.web.model.FollowerFindRequest;
import com.example.twitter.user.subscribtion.web.model.FollowerResponse;
import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;
import com.example.twitter.user.subscribtion.web.model.UnsubscribeRequest;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionAddUseCase subscriptionAddUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;
    private final SubscriptionFindFollowersUseCase subscriptionFindFollowersUseCase;

    public SubscriptionController(SubscriptionAddUseCase subscriptionAddUseCase, SubscriptionDeleteUseCase subscriptionDeleteUseCase, SubscriptionFindFollowersUseCase subscriptionFindFollowersUseCase) {
        this.subscriptionAddUseCase = subscriptionAddUseCase;
        this.subscriptionDeleteUseCase = subscriptionDeleteUseCase;
        this.subscriptionFindFollowersUseCase = subscriptionFindFollowersUseCase;
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest){
        subscriptionAddUseCase.subscribe(subscribeRequest);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest){
        subscriptionDeleteUseCase.unsubscribe(unsubscribeRequest);
    }

    @GetMapping("/followers")
    public Collection<FollowerResponse> allFollowers(@PathParam("page") int page, @PathParam("limit") int limit){

        FollowerFindRequest findRequest = new FollowerFindRequest(page,limit);
        return subscriptionFindFollowersUseCase.findFollowers(findRequest);
    }


}
