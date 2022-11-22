package com.snackpicker.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MainApplicationTests {

	@Test
	void contextLoads() {
		String a = "a";
		String b = "b";
		assertThat(a).isNotEqualTo(b);
	}

}
