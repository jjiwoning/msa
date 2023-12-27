package com.example.userservice.mock;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MockPasswordEncoder implements PasswordEncoder {

	public static String ENCODED_PASSWORD = "qwerqwerqwe";

	@Override
	public String encode(CharSequence rawPassword) {
		return ENCODED_PASSWORD;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(ENCODED_PASSWORD);
	}
}
