package com.snackpicker.main.service;

import com.snackpicker.main.dto.LoginDto;
import com.snackpicker.main.model.SnackUser;
import com.snackpicker.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void register(LoginDto dto)
    {
        SnackUser snackUser = new SnackUser();
        snackUser.setEmail(dto.getEmail());
        snackUser.setPasswordHash(dto.getPassword());

        userRepository.save(snackUser);
    }

    public boolean attemptLogin(LoginDto dto)
    {
        List<SnackUser> users = userRepository.findAll();

        for (SnackUser user : users)
        {
            if(user.getEmail().equalsIgnoreCase(dto.getEmail()))
            {
                if(user.getPasswordHash() == dto.getPassword()) return true;
            }
        }
        return false;
    }

}
