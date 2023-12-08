package com.example.twitter.user.profile.service;

import com.example.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Service;


public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
}
