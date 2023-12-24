package com.example.twitter.security.mapper.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.twitter.security.model.UserAccount;
import com.example.twitter.security.model.UserRole;
import com.example.twitter.security.service.UserRoleService;
import com.example.twitter.security.web.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Set;
@RequiredArgsConstructor
@Component
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserAccount map(RegisterRequest registerRequest) {

        UserRole userRole = this.userRoleService
                .findUserRole()
                .orElseThrow(() -> new TwitterException("User role not found"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));
        return userAccount;
    }
}
