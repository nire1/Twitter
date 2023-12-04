package com.example.twitter.security.service;

import com.example.twitter.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
