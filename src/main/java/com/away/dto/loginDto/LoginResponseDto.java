package com.away.dto.loginDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String token;
    private String userName;
    private String userEmail;
}
