package com.example.twitter.user.profile.service;

import com.example.twitter.user.profile.model.UserProfile;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    UserProfile findUserProfileByRequired(long id);
}
