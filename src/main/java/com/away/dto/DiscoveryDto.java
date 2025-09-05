package com.away.dto;

import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.security.Timestamp;

public class DiscoveryDto {

    private Long discoveryId;

    private long itemId;

    private long userId;

    private String discoveryNote;

    private  String discoveryPic;

    private String location;

    private Timestamp discoveredAt;
}