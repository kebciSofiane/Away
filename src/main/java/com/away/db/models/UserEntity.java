package com.away.db.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_pic")
    private String userPic;

    @Column(name = "user_pass")
    private String userPass;


}
