package com.example.twitter.mapper;

import com.example.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount>{
}
