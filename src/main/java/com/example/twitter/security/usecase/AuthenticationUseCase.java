package com.example.twitter.security.usecase;

import com.example.twitter.security.web.model.AccessToken;
import com.example.twitter.security.web.model.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest loginrequest);
}
