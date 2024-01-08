package com.example.twitter.user.profile.service;

import com.example.twitter.user.profile.model.UserProfile;


public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    UserProfile findUserProfileByRequired(long id);
}
