package com.away.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class ResponseItemDto {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private String itemPic;
    private Long userId;
    private String itemStartLocation;
    private Timestamp createdAt;
}
