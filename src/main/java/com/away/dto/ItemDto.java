package com.away.dto;

import jakarta.persistence.Column;

import java.security.Timestamp;

public class ItemDto {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private String itemPic;
    private Long userId;
    private String itemStartLocation;
    private Timestamp createdAt;
}
