package com.away.db.repositories;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiscoveryRepository extends JpaRepository<DiscoveryEntity,Long> {
    List<DiscoveryEntity> findByDiscoveryUser(UserEntity user);

    DiscoveryEntity findByDiscoveryId(Long id);

    List<DiscoveryEntity> findByDiscoveredItem(ItemEntity item);
}