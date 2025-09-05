package com.away.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "items")
public class ItemEntity {

        @Id
        @Column(name = "item_id")
        private Long itemId;

        @Column(name = "item_name")
        private String itemName;

        @Column(name = "item_descr")
        private String itemDescription;

        @Column(name ="item_pic")
        private  String itemPic;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity itemUser;

        @Column(name = "item_loc")
        private String itemFirstLocation;

        @Column(name = "created_at")
        private Timestamp createdAt;
}
