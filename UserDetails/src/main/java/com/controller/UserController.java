package com.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDto;
import com.modal.request.UserDetailsRequest;
import com.modal.responce.UserRest;
import com.service.UserService;

@RestController
@RequestMapping("/user") // "Calls http request url http://localhost:8080/user
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "get user is called";
	}

	@PostMapping
	public UserRest addUser(@RequestBody UserDetailsRequest userDetailsRequest) {

		UserRest returnValue = new UserRest();

		UserDto userdto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequest, userdto);

		UserDto createUser = userService.createUser(userdto);
		BeanUtils.copyProperties(createUser, returnValue);

		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "update user is called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete mapping is called";
	}
}