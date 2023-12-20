package com.example.twitter.user.subscribtion.web.model;

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(@NotNull Long followedId) {
}
