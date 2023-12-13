package com.example.twitter.user.profile.api.service;

import com.example.twitter.user.profile.model.UserProfile;
import org.springframework.security.core.userdetails.User;

public interface CurrentUserProfileApiService {
    UserProfile currentUserProfile();
}
