package com.away.Services;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.db.repositories.DiscoveryRepository;
import com.away.db.repositories.ItemRepository;
import com.away.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoveriesService {

    private final DiscoveryRepository discoveryRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public DiscoveriesService(DiscoveryRepository discoveryRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.discoveryRepository = discoveryRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
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

    public List<DiscoveryEntity> getDiscoveryByItem(long itemId) {
            return discoveryRepository.findByDiscoveredItem(itemRepository.findByItemId(itemId));
    }

    public List<DiscoveryEntity> getDiscoveryByUser(long userId) {
       //return discoveryRepository.findByDiscoveryUser(userRepository.findByUserId(userId));
    return null;
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

    public void deleteDiscovery(long discoveryId) {
        if (discoveryRepository.existsById(discoveryId)) {
            discoveryRepository.deleteById(discoveryId);
        } else  {
            /* TODO throw now discovery found exception*/
        }
    }


}
