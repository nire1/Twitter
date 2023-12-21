package com.example.twitter.security.usecase.Impl;

import com.example.twitter.security.service.AccessTokenService;
import com.example.twitter.security.usecase.AuthenticationUseCase;
import com.example.twitter.security.web.model.AccessToken;
import com.example.twitter.security.web.model.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUseCaseFacade implements AuthenticationUseCase {
    private final AuthenticationManager authenticationManager;
    private final AccessTokenService accessTokenService;

    public AuthenticationUseCaseFacade(AuthenticationManager authenticationManager, AccessTokenService accessTokenService) {
        this.authenticationManager = authenticationManager;
        this.accessTokenService = accessTokenService;
    }

    @Override
    public AccessToken authenticate(LoginRequest loginrequest) {

       Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                loginrequest.username(),
                loginrequest.password()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String idToken = accessTokenService.generateIdToken(authentication);

        return new AccessToken(idToken);
    }
}
