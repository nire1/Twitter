package com.example.twitter.user.profile.mapper;

import com.example.twitter.common.mapper.Mapper;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper
        extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
