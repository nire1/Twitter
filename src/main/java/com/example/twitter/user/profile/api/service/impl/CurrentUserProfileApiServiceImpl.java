package com.example.twitter.user.profile.api.service.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.security.api.model.CurrentUserApiModel;
import com.example.twitter.security.api.service.IdentityApiService;
import com.example.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {

    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    public CurrentUserProfileApiServiceImpl(IdentityApiService identityApiService, UserProfileService userProfileService) {
        this.identityApiService = identityApiService;
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserApiModel currentUserApiModel = identityApiService.currentUserAccount()
                .orElseThrow(() -> new TwitterException("Пользователь должен быть авторизован в системе"));

        return userProfileService
                .findUserProfileByRequired(currentUserApiModel.userAccountId())
                ;

    }
}
