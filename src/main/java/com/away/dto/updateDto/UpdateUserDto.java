package com.away.dto.updateDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String userPic;

    @NotBlank
    @Size(min = 6, max = 30, message = "Le mot de passe doit contenir entre 6 et 30 caractères")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).*$",
            message = "Le mot de passe doit contenir au moins une majuscule et un caractère spécial"
    )
    private String userPass;
}
