package com.example.userservice.application;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.userservice.domain.User;
import com.example.userservice.domain.UserRepository;
import com.example.userservice.domain.mapper.UserMapper;
import com.example.userservice.dto.request.UserCreateRequest;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserService 단위 테스트")
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	@InjectMocks
	private UserService userService;

	@Test
	@DisplayName("유저 생성에 성공한다.")
	void create() {
		// given
		final String email = "aaa@aaa.com";
		final String name = "tamtam";
		final String rawPassword = "qwer";
		final String encodedPassword = "qweqweqweqwesad";

		UserCreateRequest request = UserCreateRequest.of(email, name, rawPassword);
		User user = User.of(email, name, encodedPassword);

		when(userMapper.mapFrom(request))
			.thenReturn(user);
		when(userRepository.save(user))
			.thenReturn(User.builder().id(1L).name(name).password(encodedPassword).email(email).build());

		// when
		Long result = userService.createUser(request);

		// then
		assertThat(result).isEqualTo(1L);
	}
}
