package com.example.twitter.security.service;

import com.example.twitter.security.model.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);

    Optional<UserAccount> findByUsername(String username);
}
