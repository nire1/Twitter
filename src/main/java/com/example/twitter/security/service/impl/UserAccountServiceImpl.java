package com.example.twitter.security.service.impl;

import com.example.twitter.common.exception.TwitterException;
import com.example.twitter.security.model.UserAccount;
import com.example.twitter.security.repository.UserAccountRepository;
import com.example.twitter.security.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean isUsernameExists= userAccountRepository.existsByUsername(userAccount.getUsername());

        if(isUsernameExists){
            throw new TwitterException("Account with this username already exists");
        }

        this.userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }
}
