package com.away.dto;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class ItemDto {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private String itemPic;
    private Long userId;
    private String itemStartLocation;
    private Timestamp createdAt;
}
