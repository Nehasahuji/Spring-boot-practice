package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDto;
import com.exception.UserServiceException;
import com.modal.exceptions.ErrorMessage;
import com.modal.request.UserDetailsRequest;
import com.modal.responce.OperationStatusModal;
import com.modal.responce.RequestOperationName;
import com.modal.responce.RequestOperationStatus;
import com.modal.responce.UserRest;
import com.service.UserService;

@RestController
@RequestMapping("/user") // "Calls http request url http://localhost:8080/user
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest createUser(@RequestBody UserDetailsRequest userDetailsRequest) throws Exception {

		UserRest returnValue = new UserRest();

		if (userDetailsRequest.getFirstName().isEmpty())
			throw new UserServiceException(ErrorMessage.MISSING_REQUIRED_FIELD.getErrorMessage());

		UserDto userdto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequest, userdto);

		UserDto createUser = userService.createUser(userdto);
		BeanUtils.copyProperties(createUser, returnValue);

		return returnValue;
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequest userDetailsRequest) {

		UserRest returnValue = new UserRest();
		UserDto userdto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequest, userdto);

		UserDto updateUser = userService.updateUser(userdto, id);
		BeanUtils.copyProperties(updateUser, returnValue);

		return returnValue;

	}

	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModal deleteUser(@PathVariable String id) {
		OperationStatusModal returnValue = new OperationStatusModal();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		userService.deleteUser(id);
		returnValue.setOperationStatus(RequestOperationStatus.SUCESS.name());
		return returnValue;
	}

//	get user details and pagination support\
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<UserRest> returnValue = new ArrayList<UserRest>();

		List<UserDto> users = userService.getUsers(page, limit);

		for (UserDto userDto : users) {
			UserRest userModal = new UserRest();
			BeanUtils.copyProperties(userDto, userModal);
			returnValue.add(userModal);
		}

		return returnValue;

	}
}
