package com.example.userservice.domain.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.userservice.domain.User;
import com.example.userservice.dto.request.UserCreateRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {

	private final PasswordEncoder passwordEncoder;

	public User mapFrom(final UserCreateRequest request) {
		return User.of(request.getEmail(), request.getName(), passwordEncoder.encode(request.getPassword()));
	}
}
