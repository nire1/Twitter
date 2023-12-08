package com.example.twitter.security.service.impl;

import com.example.twitter.security.mapper.UserAccountToUserMapper;
import com.example.twitter.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;
    private final UserAccountToUserMapper mapper;
    public UserDetailsServiceImpl(UserAccountService userAccountService, UserAccountToUserMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService
                .findByUsername(username)
                .map(mapper::map)
                .orElseThrow(()-> new UsernameNotFoundException("Неверные учетные данные пользователя"));
    }
}
