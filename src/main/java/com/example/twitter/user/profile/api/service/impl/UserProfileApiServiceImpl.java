package com.example.twitter.user.profile.api.service.impl;

import com.example.twitter.user.profile.api.service.UserProfileApiService;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileApiServiceImpl implements UserProfileApiService {
    private final UserProfileService userProfileService;

    public UserProfileApiServiceImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile findUserProfileById(long userProfileId) {
        return userProfileService.findUserProfileByRequired(userProfileId);
    }
}
