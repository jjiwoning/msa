package com.example.userservice.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.userservice.domain.UserRepository;
import com.example.userservice.domain.mapper.UserMapper;
import com.example.userservice.dto.request.UserCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public Long createUser(final UserCreateRequest request) {
		return userRepository.save(userMapper.mapFrom(request)).getId();
	}

}
