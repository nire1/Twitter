package com.example.twitter.user.subscribtion.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record FollowerFindRequest(
        @Min(0)
        int page,
        @Min(25)
        @Max(100)
        int limit
) {
}
