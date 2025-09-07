package com.away.Services;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.db.repositories.DiscoveryRepository;
import com.away.db.repositories.ItemRepository;
import com.away.db.repositories.UserRepository;
import com.away.dto.createDto.CreateDiscoveryDto;
import com.away.dto.responseDto.ResponseDiscoveryDto;
import com.away.dto.updateDto.UpdateDiscoveryDto;
import com.away.exceptions.discovery.DiscoveryAlreadyExistsException;
import com.away.exceptions.discovery.DiscoveryNotFoundException;
import com.away.exceptions.item.ItemNotFoundException;
import com.away.exceptions.user.UserNotFoundException;
import com.away.mappers.DiscoveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoveriesService {

    private final DiscoveryRepository discoveryRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final DiscoveryMapper discoveryMapper;

    @Autowired
    public DiscoveriesService(DiscoveryRepository discoveryRepository, ItemRepository itemRepository, UserRepository userRepository, ItemRepository itemRepository1, UserRepository userRepository1, DiscoveryMapper discoveryMapper) {
        this.discoveryRepository = discoveryRepository;
        this.itemRepository = itemRepository1;
        this.userRepository = userRepository1;
        this.discoveryMapper = discoveryMapper;
    }

    public List<ResponseDiscoveryDto> getAllDiscoveries() {

        return discoveryMapper.toResponseDiscoveryDTOs(discoveryRepository.findAll());
    }

    public ResponseDiscoveryDto getDiscoveryById(long discoveryId) {
        DiscoveryEntity discoveryEntity = discoveryRepository.findById(discoveryId)
                .orElseThrow(() -> new DiscoveryNotFoundException(discoveryId));
        return discoveryMapper.toResponseDiscoveryDTO(discoveryEntity);
    }

    public List<ResponseDiscoveryDto> getDiscoveryByItem(long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException(itemId)
        );
        return discoveryMapper.toResponseDiscoveryDTOs(discoveryRepository.findByDiscoveredItem(itemEntity));
    }

    public List<ResponseDiscoveryDto> getDiscoveryByUser(long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        return discoveryMapper.toResponseDiscoveryDTOs(discoveryRepository.findByDiscoveryUser(userEntity));
    }

    public ResponseDiscoveryDto addDiscovery(CreateDiscoveryDto createDiscoveryDto) {
      UserEntity userEntity =  userRepository.findByUserId(createDiscoveryDto.getUserId())
                .orElseThrow(
                        () -> new UserNotFoundException(createDiscoveryDto.getUserId())
                );
      ItemEntity itemEntity = itemRepository.findByItemId(createDiscoveryDto.getItemId())
              .orElseThrow(
                      () -> new ItemNotFoundException(createDiscoveryDto.getItemId())
              );
      if (discoveryRepository.existsByDiscoveredItemAndDiscoveryUser(itemEntity, userEntity)){
            throw new DiscoveryAlreadyExistsException(itemEntity.getItemId());
      }

        DiscoveryEntity discoveryEntity = discoveryMapper.toDiscoveryEntity(createDiscoveryDto);
        discoveryEntity.setDiscoveryUser(userEntity);
        discoveryEntity.setDiscoveredItem(itemEntity);

        DiscoveryEntity createdDiscovery = discoveryRepository.save(discoveryEntity);
        return discoveryMapper.toResponseDiscoveryDTO(createdDiscovery);
    }

    public ResponseDiscoveryDto updateDiscovery(UpdateDiscoveryDto updateDiscoveryDto, long discoveryId) {
      return discoveryRepository.findById(discoveryId)
              .map( discoveryEntity -> {
                  discoveryMapper.updateDiscoveryFromDto(updateDiscoveryDto, discoveryEntity);
                  DiscoveryEntity savedDiscovery= discoveryRepository.save(discoveryEntity);
                  return discoveryMapper.toResponseDiscoveryDTO(savedDiscovery);
                      }
              )
              .orElseThrow(
                      () -> new DiscoveryNotFoundException(discoveryId)
              );
    }

    public void deleteDiscovery(long discoveryId) {
       DiscoveryEntity  discoveryEntity = discoveryRepository.findById(discoveryId).orElseThrow(
               () -> new DiscoveryNotFoundException(discoveryId)
       );
       discoveryRepository.delete(discoveryEntity);
    }


}
