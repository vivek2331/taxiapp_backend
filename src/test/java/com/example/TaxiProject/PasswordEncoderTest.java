package com.example.project2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

	@Test
	public void encode_password() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.print(passwordEncoder.encode("1234"));
	}
}
