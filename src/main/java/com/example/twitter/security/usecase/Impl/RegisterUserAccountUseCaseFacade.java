package com.example.twitter.security.usecase.Impl;

import com.example.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.twitter.security.model.UserAccount;
import com.example.twitter.security.service.UserAccountService;
import com.example.twitter.security.web.model.RegisterRequest;
import com.example.twitter.security.usecase.RegisterUserAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;
    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = mapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
