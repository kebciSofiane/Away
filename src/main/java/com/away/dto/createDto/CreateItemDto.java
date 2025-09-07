package com.away.dto.createDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemDto {

    @NotBlank
    private String itemName;

    @Size(max = 500)
    private String itemDescription;

    @NotNull
    @NotBlank
    private String itemPic;

    @NotNull
    private Long userId;

    @NotNull
    private String itemStartLocation;

    @Override
    public String toString() {
        return "CreateItemDto{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPic='" + itemPic + '\'' +
                ", userId=" + userId +
                ", itemFirstLocation='" + itemStartLocation + '\'' +
                '}';
    }
}
