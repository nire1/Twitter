package com.example.twitter.user.profile.service.impl;

import com.example.twitter.security.repository.UserAccountRepository;
import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.profile.repository.UserProfileRepository;
import com.example.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new RuntimeException(errorMessage);
        }
        if(userProfileRepository.existsByNickname(userProfile.getNickname())){
            String errorMessage = String
                    .format(
                            "Профиль пользователя с Id = %s ранее уже был создан",
                            userProfile.getNickname()
                    );
            throw new RuntimeException(errorMessage);
        }

        userProfileRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> findUserProfileById(long id) {
        return userProfileRepository.findById(id);
    }
}
