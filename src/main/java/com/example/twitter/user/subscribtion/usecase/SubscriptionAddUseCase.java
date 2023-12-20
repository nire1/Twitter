package com.example.twitter.user.subscribtion.usecase;

import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;

public interface SubscriptionAddUseCase {
    void subscribe(SubscribeRequest subscribeRequest);
}
