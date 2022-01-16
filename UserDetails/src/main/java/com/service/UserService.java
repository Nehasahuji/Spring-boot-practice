package com.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userdto);

	UserDto getUser(String email);

	UserDto getUserByUserId(String userId);

	UserDto updateUser(UserDto userdto, String id);

	void deleteUser(String userId);

	List<UserDto> getUsers(int page, int limit);
}
