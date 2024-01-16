package com.example.rezarvationapp.service.auth;

import com.example.rezarvationapp.dao.entity.UserEntity;
import com.example.rezarvationapp.dao.repository.UserRepository;
import com.example.rezarvationapp.model.authDto.AuthRequestDto;
import com.example.rezarvationapp.model.authDto.AuthenticationDto;
import com.example.rezarvationapp.model.authDto.UserRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public void register(UserRegisterRequestDto requestDto) {
        UserEntity.builder()
                .fullName(requestDto.getFullName())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();


    }

    public AuthenticationDto authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmail(),
                        authRequestDto.getPassword()
                )
        );

        UserEntity user = userRepository.findUserByEmail(authRequestDto.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationDto.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

    public static UserEntity getUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
