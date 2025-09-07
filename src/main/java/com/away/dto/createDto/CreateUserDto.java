package com.away.dto.createDto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String userPic;

    @Email
    @NotBlank
    private String userEmail;

    @NotBlank
    @Size(min = 6, max = 30, message = "Le mot de passe doit contenir entre 6 et 30 caractères")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).*$",
            message = "Le mot de passe doit contenir au moins une majuscule et un caractère spécial"
    )
    private String userPass;

}
