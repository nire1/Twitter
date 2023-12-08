package com.example.twitter.user.profile.usecase.impl;

import com.example.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.service.UserProfileService;
import com.example.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import com.example.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService, UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = mapper.map(registerRequest);
        userProfileService.createUserProfile(userProfile);
    }
}
