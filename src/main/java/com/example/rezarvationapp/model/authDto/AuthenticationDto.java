package com.example.rezarvationapp.model.authDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDto {

    private String token;
    private String refreshToken;
    private String message;
}
