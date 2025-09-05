package com.away.Services;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.db.repositories.DiscoveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoveriesService {

    private final DiscoveryRepository discoveryRepository;

    @Autowired
    public DiscoveriesService(DiscoveryRepository discoveryRepository) {
        this.discoveryRepository = discoveryRepository;
    }

    public List<DiscoveryEntity> getAllDiscoveries() {
        return discoveryRepository.findAll();
    }

    public DiscoveryEntity getDiscoveryById(long discoveryId) {
        if (discoveryRepository.existsById(discoveryId)) {
            return discoveryRepository.findByDiscoveryId(discoveryId);
        } else {
            /* TODO exception Discovery Doesn't exist */
            return null;
        }
    }

    public List<DiscoveryEntity> getDiscoveryByItem(ItemEntity item) {
            return discoveryRepository.findByDiscoveredItem(item);
    }

    public List<DiscoveryEntity> getDiscoveryByUser(UserEntity user) {
        return discoveryRepository.findByDiscoveryUser(user);
    }

    public DiscoveryEntity addDiscovery(DiscoveryEntity discoveryEntity) {
        if (!discoveryRepository.existsById(discoveryEntity.getDiscoveryId())) {
            return discoveryRepository.save(discoveryEntity);
        } else  {
            /*TODO Discovery already exists */
            return null;
        }
    }
    public DiscoveryEntity updateDiscovery(DiscoveryEntity discoveryEntity) {
        if (discoveryRepository.existsById(discoveryEntity.getDiscoveryId())) {
            return discoveryRepository.save(discoveryEntity);
        }else  {
            /*TODO Discovery doesn't exists */
            return null;
        }
    }





}
