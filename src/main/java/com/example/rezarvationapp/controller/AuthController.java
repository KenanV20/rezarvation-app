package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.authDto.AuthRequestDto;
import com.example.rezarvationapp.model.authDto.AuthenticationDto;
import com.example.rezarvationapp.model.authDto.UserRegisterRequestDto;
import com.example.rezarvationapp.model.responseDto.SimpleMessageDto;
import com.example.rezarvationapp.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public SimpleMessageDto<String> register(
            @RequestBody UserRegisterRequestDto requestDto
    ) {
        authService.register(requestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @PostMapping("/login")
    public SimpleMessageDto<AuthenticationDto> register(
            @RequestBody AuthRequestDto authRequestDto
    ) {

        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), authService.authenticate(authRequestDto));

    }
}