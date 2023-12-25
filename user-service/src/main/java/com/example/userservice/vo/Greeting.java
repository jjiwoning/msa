package com.example.userservice.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Greeting {

	private final String message;

	public Greeting(@Value("${greeting.message}") final String message) {
		this.message = message;
	}
}
