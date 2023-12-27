package com.example.userservice.domain.mapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userservice.domain.User;
import com.example.userservice.dto.request.UserCreateRequest;
import com.example.userservice.mock.MockPasswordEncoder;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserMapper 단위 테스트")
class UserMapperTest {

	@Spy
	private PasswordEncoder passwordEncoder = new MockPasswordEncoder();

	@InjectMocks
	private UserMapper userMapper;

	@Test
	@DisplayName("UserRequest를 User로 Mapping한다.")
	public void map() {
		// given
		final String email = "aaa@aaa.com";
		final String name = "tamtam";
		final String rawPassword = "qwer";

		UserCreateRequest request = UserCreateRequest.of(email, name, rawPassword);

		// when
		User result = userMapper.mapFrom(request);

		// then
		assertThat(result.getName()).isEqualTo(name);
		assertThat(result.getPassword()).isEqualTo(MockPasswordEncoder.ENCODED_PASSWORD);
		assertThat(result.getEmail()).isEqualTo(email);
	}
}
