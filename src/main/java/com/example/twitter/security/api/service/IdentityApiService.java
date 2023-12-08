package com.example.twitter.security.api.service;

import com.example.twitter.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
