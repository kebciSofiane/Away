package com.away.db.models;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "items")
public class ItemEntity {

        @Id
        @Column(name = "item_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long itemId;

        @Column(name = "item_name")
        private String itemName;

        @Column(name = "item_descr")
        private String itemDescription;

        @Column(name ="item_pic")
        private  String itemPic;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private UserEntity itemUser;

        @Column(name = "item_loc")
        private String itemStartLocation;

        @CreationTimestamp
        @Column(name = "created_at", updatable = false)
        private Timestamp createdAt;


        @Override
        public String toString() {
                return "ItemEntity{" +
                        "itemId=" + itemId +
                        ", itemName='" + itemName + '\'' +
                        ", itemDescription='" + itemDescription + '\'' +
                        ", itemPic='" + itemPic + '\'' +
                        ", itemUser=" + itemUser +
                        ", itemFirstLocation='" + itemStartLocation + '\'' +
                        ", createdAt=" + createdAt +
                        '}';
        }
}
