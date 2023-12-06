package com.example.twitter.usecase;

import com.example.twitter.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
