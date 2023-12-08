package com.example.twitter.security.api.service.impl;

import com.example.twitter.security.api.model.CurrentUserApiModel;
import com.example.twitter.security.api.service.IdentityApiService;
import com.example.twitter.security.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService userAccountService;

    public IdentityApiServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if(authentication == null) {
            return Optional.empty();
        }
        String username = authentication.getName();
        return userAccountService.findByUsername(username).map(userAccount -> new CurrentUserApiModel(userAccount.getId()));

    }
}
