package com.example.twitter.user.subscribtion.web.model;

import java.util.Collection;

public record FollowerPageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<FollowerResponse> followers
) {
}
