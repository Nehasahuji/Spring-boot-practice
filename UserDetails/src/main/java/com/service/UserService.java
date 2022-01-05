package com.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userdto);

	UserDto getUser(String email);
}
