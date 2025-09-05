package com.away.db.repositories;

import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

    ItemEntity findByItemId(long id);
    List<ItemEntity> findByItemUser(UserEntity user);
    Boolean existsByItemId(long id);
    Boolean existsByItemUser(UserEntity user);
}
