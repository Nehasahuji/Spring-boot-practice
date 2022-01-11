package com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.UserDto;
import com.dto.Utils;
import com.entity.UserEntity;
import com.exception.UserServiceException;
import com.modal.exceptions.ErrorMessage;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		UserEntity storedUser = userRepository.findByEmail(user.getEmail());

		if (storedUser != null)
			throw new RuntimeException("record already exist");

		UserEntity userDetail = new UserEntity();
		BeanUtils.copyProperties(user, userDetail);

		String PublicUSerId = utils.genratedUserID(30);
		userDetail.setUserId(PublicUSerId);

		userDetail.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		UserEntity storedUserDetail = userRepository.save(userDetail);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetail, returnValue);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmail(email);

		if (user == null)
			throw new UsernameNotFoundException(email);

		return new User(user.getEmail(), user.getEncryptedPassword(), new ArrayList<GrantedAuthority>());
	}

	@Override
	public UserDto getUser(String email) {

		UserEntity user = userRepository.findByEmail(email);

		if (user == null)
			throw new UsernameNotFoundException(email);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(user, returnValue);

		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public UserDto updateUser(UserDto userdto, String userId) {

		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UserServiceException(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());

		userEntity.setFirstName(userdto.getFirstName());
		userEntity.setLastName(userdto.getLastName());

		UserEntity updatedUserDetails = userRepository.save(userEntity);

		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		return returnValue;

	}
}
