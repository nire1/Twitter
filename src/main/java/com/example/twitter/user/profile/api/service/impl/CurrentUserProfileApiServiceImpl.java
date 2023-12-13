package com.example.twitter.user.profile.api.service.impl;

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
                .orElseThrow(() -> new RuntimeException("Пользователь должен быть авторизован в системе"));

        return userProfileService
                .findUserProfileById(currentUserApiModel.userAccountId())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Профиль пользователя с id = %d в системе не существует",
                            currentUserApiModel.userAccountId()
                    );
                    return new RuntimeException(errorMessage);
                });

    }
}
