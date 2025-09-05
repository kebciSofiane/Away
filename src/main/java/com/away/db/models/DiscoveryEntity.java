package com.away.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "discovered_objects")
public class DiscoveryEntity {

    @Id
    @Column(name = "disc_id")
    private Long discoveryId;

    @ManyToOne
    @JoinColumn(name = "ob_id")
    private ItemEntity discoveredItem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity discoveryUser;

    @Column(name = "disc_note")
    private String discoveryNote;

    @Column(name ="disc_pic")
    private  String discoveryPic;

    @Column(name = "disc_loc")
    private String location;

    @Column(name = "discovered_at")
    private Timestamp discoveredAt;
}
