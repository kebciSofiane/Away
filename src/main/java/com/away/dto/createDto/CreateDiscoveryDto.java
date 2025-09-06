package com.away.dto.createDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiscoveryDto {

    private long userId;

    private String discoveryNote;

    private  String discoveryPic;

    private String location;

}
