package com.snackpicker.main.MockRepos;

import com.snackpicker.main.dto.LoginDto;
import com.snackpicker.main.model.SnackUser;
import com.snackpicker.main.repository.UserRepository;
import com.snackpicker.main.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    private AuthService authService;

    List<SnackUser> userList;

    @BeforeEach
    void setup()
    {
        this.authService = new AuthService(userRepository);
    }

    @Test
    void LoginTest()
    {
        userList = new ArrayList<>();

        SnackUser user1 = new SnackUser();
        user1.setId((long)1);
        user1.setEmail("test@test");
        user1.setPasswordHash("AABBCCDD");
        userList.add(user1);

        LoginDto dto = new LoginDto();
        dto.Password = "AABBCCDD";
        dto.setEmail("test@test");

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        SnackUser loggedInUser = authService.attemptLogin(dto);

        Assertions.assertEquals(1, loggedInUser.getId());
        Assertions.assertEquals("test@test",loggedInUser.getEmail());
        Assertions.assertEquals("AABBCCDD", loggedInUser.getPasswordHash());
    }

    @Test
    void RegisterTest()
    {
        LoginDto dto = new LoginDto();
        dto.setEmail("test@test");
        dto.Password = "Password";

        SnackUser user1 = new SnackUser();
        user1.setId(1L);
        user1.setPasswordHash("Password");
        user1.setEmail("test@test");

        Mockito.when(userRepository.save(any(SnackUser.class))).thenReturn(user1);

        SnackUser savedUser = authService.register(dto);

        Assertions.assertEquals(1L, savedUser.getId());
        Assertions.assertEquals("test@test", savedUser.getEmail());
        Assertions.assertEquals("Password", savedUser.getPasswordHash());
    }

}
