package com.example.twitter.user.subscribtion.web;

import com.example.twitter.user.subscribtion.usecase.SubscriptionAddUseCase;
import com.example.twitter.user.subscribtion.usecase.SubscriptionDeleteUseCase;
import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;
import com.example.twitter.user.subscribtion.web.model.UnsubscribeRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionAddUseCase subscriptionAddUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;

    public SubscriptionController(SubscriptionAddUseCase subscriptionAddUseCase, SubscriptionDeleteUseCase subscriptionDeleteUseCase) {
        this.subscriptionAddUseCase = subscriptionAddUseCase;
        this.subscriptionDeleteUseCase = subscriptionDeleteUseCase;
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest){
        subscriptionAddUseCase.subscribe(subscribeRequest);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest){
        subscriptionDeleteUseCase.unsubscribe(unsubscribeRequest);
    }


}
