package com.example.twitter.user.subscribtion.mapper;

import com.example.twitter.security.mapper.Mapper;
import com.example.twitter.user.subscribtion.model.Subscription;
import com.example.twitter.user.subscribtion.web.model.SubscribeRequest;
import jakarta.persistence.ManyToOne;

public interface SubscribeRequestToSubscriptionMapper extends Mapper<Subscription, SubscribeRequest> {
}
