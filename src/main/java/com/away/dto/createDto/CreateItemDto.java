package com.away.dto.createDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemDto {

    private String itemName;
    private String itemDescription;
    private String itemPic;
    private Long userId;
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
