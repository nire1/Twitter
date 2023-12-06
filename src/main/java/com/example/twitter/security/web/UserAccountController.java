package com.example.twitter.security.web;

import com.example.twitter.mapper.RegisterRequestToUserAccountMapper;
import com.example.twitter.security.model.UserAccount;
import com.example.twitter.security.model.UserRole;
import com.example.twitter.security.service.UserAccountService;
import com.example.twitter.security.service.UserRoleService;
import com.example.twitter.security.web.model.RegisterRequest;
import com.example.twitter.usecase.RegisterUserAccountUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {

    private final RegisterUserAccountUseCase registerUserAccountUseCase;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        registerUserAccountUseCase.register(registerRequest);
    }
}
