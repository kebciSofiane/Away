package com.away.db.models;

import jakarta.persistence.*;

@Entity
@Table(name = "objects")
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

}
