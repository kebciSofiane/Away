package com.away.dto;

import com.away.db.models.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

public class UserDto {

    private String userId;
    private String userName;
    private String userPic;

}
