package com.example.twitter.security.service.impl;

import com.example.twitter.security.model.UserRole;
import com.example.twitter.security.repository.UserRoleRepository;
import com.example.twitter.security.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }
}
