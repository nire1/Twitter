package com.example.twitter.user.subscribtion.usecase;

import com.example.twitter.user.subscribtion.web.model.UnsubscribeRequest;

public interface SubscriptionDeleteUseCase {
    void unsubscribe(UnsubscribeRequest unsubscribeRequest);
}
