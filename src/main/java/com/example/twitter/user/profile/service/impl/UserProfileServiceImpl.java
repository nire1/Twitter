package com.example.twitter.user.profile.service.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.repository.UserProfileRepository;
import com.example.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if(userProfileRepository.existsById(userProfile.getId())){
            String errorMessage = String
                    .format(
                            "Профиль пользователя с Id = %d ранее уже был создан",
                            userProfile.getId()
                    );
            throw new TwitterException(errorMessage);
        }
        if(userProfileRepository.existsByNickname(userProfile.getNickname())){
            String errorMessage = String
                    .format(
                            "Профиль пользователя с Id = %s ранее уже был создан",
                            userProfile.getNickname()
                    );
            throw new TwitterException(errorMessage);
        }

        userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileByRequired(long id) {
        return userProfileRepository.findById(id).orElseThrow(() -> {
            String errorMessage = String.format("Профиль пользователя с id = %d в системе не существует",
                    id
            );
            return new TwitterException(errorMessage);
        });
    }
}
