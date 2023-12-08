package com.example.twitter.user.profile.web;

import com.example.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import com.example.twitter.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileRegisterUseCase registerUseCase;

    public UserProfileController(UserProfileRegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest registerRequest){
        registerUseCase.registerUserProfile(registerRequest);
    }
}
