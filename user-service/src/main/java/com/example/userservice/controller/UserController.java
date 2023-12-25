package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.vo.Greeting;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final Greeting greeting;

	@GetMapping("/health-check")
	public String status() {
		return "It's Working in User Service";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return greeting.getMessage();
	}
}
