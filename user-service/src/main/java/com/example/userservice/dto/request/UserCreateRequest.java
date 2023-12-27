package com.example.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCreateRequest {

	@Email(message = "올바른 이메일 형식이 아닙니다.ㄴ")
	@NotNull(message = "이메일이 공백입니다.")
	private String email;

	@NotNull
	@Size(min = 2)
	private String name;

	@NotNull
	@Size(min = 8)
	private String password;

	public static UserCreateRequest of(final String email, final String name, final String password) {
		return new UserCreateRequest(email, name, password);
	}
}
