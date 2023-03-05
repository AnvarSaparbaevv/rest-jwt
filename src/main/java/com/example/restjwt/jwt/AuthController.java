package com.example.restjwt.jwt;

import com.example.restjwt.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    UserDetailsServise userDetailsServise;

    @Autowired
    JwtProvider jwtProvider;



    @PostMapping("/login")
    public ResponseEntity<?> loginToSystem(@RequestBody LoginDto loginDto) {
        UserDetails userDetails = userDetailsServise.loadUserByUsername(loginDto.getUsername());
        if (userDetails.getPassword().equals(loginDto.getPassword())) {
            String token = jwtProvider.createToken(loginDto.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("User/Password not found");
    }
}
