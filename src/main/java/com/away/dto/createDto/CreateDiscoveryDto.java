package com.away.dto.createDto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiscoveryDto {

    @NotNull
    private long userId;

    @NotNull
    private long itemId;

    private String discoveryNote;

    private  String discoveryPic;

    @NotNull
    private String location;

}
