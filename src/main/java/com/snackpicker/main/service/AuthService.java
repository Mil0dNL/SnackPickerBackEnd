package com.snackpicker.main.service;

import com.snackpicker.main.dto.LoginDto;
import com.snackpicker.main.model.SnackUser;
import com.snackpicker.main.repository.UserRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;

    SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final Claims claims = Jwts.claims();

    private static final String ISSUER = "SnackjeWeb";

    @Autowired
    public AuthService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //generates JWT token
    public String generateAuthString(SnackUser user)
    {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) + 7);

        claims.setIssuer(ISSUER);
        claims.setSubject(String.valueOf(user.getId()));
        claims.setExpiration(date.getTime());

        String value = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256").setClaims(claims)
                .claim("Email", user.getEmail()).signWith(secretKey).compact();

        return value;
    }

    public SnackUser register(LoginDto dto)
    {
        SnackUser snackUser = new SnackUser();
        snackUser.setEmail(dto.getEmail());
        snackUser.setPasswordHash(dto.getPassword());

        return userRepository.save(snackUser);
    }

    public SnackUser attemptLogin(LoginDto dto)
    {
        List<SnackUser> users = userRepository.findAll();

        for (SnackUser user : users)
        {
            if(user.getEmail().equalsIgnoreCase(dto.getEmail()))
            {
                if(user.getPasswordHash().trim().equals(dto.getPassword().trim())) {return user;}
            }
        }
        return null;
    }

}
