package com.snackpicker.main.controller;

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

    @GetMapping("register")
    public ResponseEntity<Void> register()
    {
        try
        {
            LoginDto dto = new LoginDto();
            dto.setEmail("ikben@milodorigo.nl");
            dto.setPassword("Password");
            authService.register(dto);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("login")
    public ResponseEntity<SnackUser> login(@RequestBody LoginDto loginDto)
    {
        System.out.println(loginDto.getEmail() + loginDto.getPassword());
        try
        {
            if(authService.attemptLogin(loginDto))
            {
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
