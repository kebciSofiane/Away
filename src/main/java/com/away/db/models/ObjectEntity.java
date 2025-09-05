package com.away.db.models;

import jakarta.persistence.*;

@Entity
@Table(name = "objects")
public class ObjectEntity {

        @Id
        @Column(name = "ob_id")
        private Long objectId;

        @Column(name = "ob_name")
        private String objectName;

        @Column(name = "ob_descr")
        private String objectDescription;

        @Column(name ="ob_pic")
        private  String objectPic;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity obUser;

        @Column(name = "ob_loc")
        private String objectLocation;

}
