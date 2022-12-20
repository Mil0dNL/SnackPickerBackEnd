package com.snackpicker.main.controller;

import com.snackpicker.main.dto.LoggedInUserDto;
import com.snackpicker.main.dto.LoginDto;
import com.snackpicker.main.model.SnackUser;
import com.snackpicker.main.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/Authentication")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody LoginDto loginDto)
    {
        try
        {
            authService.register(loginDto);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("login")
    public ResponseEntity<LoggedInUserDto> login(@RequestBody LoginDto loginDto)
    {
        try
        {
            SnackUser user = authService.attemptLogin(loginDto);

            if(user != null)
            {
                String JWT = authService.generateAuthString(user);

                LoggedInUserDto returnDto = new LoggedInUserDto();
                returnDto.id = user.getId();
                returnDto.JWT = JWT;
                returnDto.Email = user.getEmail();

                return ResponseEntity.status(HttpStatus.OK).body(returnDto);
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
