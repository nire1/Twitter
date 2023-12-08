package com.example.twitter.user.profile.mapper;

import com.example.twitter.security.mapper.Mapper;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.persistence.ManyToMany;

public interface UserProfileRegisterRequestToUserProfileMapper
        extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
