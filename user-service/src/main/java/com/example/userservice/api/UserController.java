package com.example.userservice.api;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.application.UserService;
import com.example.userservice.dto.request.UserCreateRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/users")
	public ResponseEntity<Void> create(@RequestBody final UserCreateRequest request) {
		final Long id = userService.createUser(request);
		return ResponseEntity.created(URI.create("/users/" + id)).build();
	}
}
