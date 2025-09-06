package com.away.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ResponseDiscoveryDto {

    private Long discoveryId;

    private long itemId;

    private long userId;

    private String discoveryNote;

    private  String discoveryPic;

    private String location;

    private Timestamp discoveredAt;
}