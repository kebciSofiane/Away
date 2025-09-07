package com.away.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "user_pic")
    private String userPic;

    @Column(name = "user_pass")
    private String userPass;

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPic='" + userPic + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
