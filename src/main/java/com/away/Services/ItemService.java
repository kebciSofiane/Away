package com.away.Services;

import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.db.repositories.ItemRepository;
import com.away.db.repositories.UserRepository;
import com.away.dto.createDto.CreateItemDto;
import com.away.dto.responseDto.ResponseItemDto;
import com.away.exceptions.item.ItemAlreadyExistsException;
import com.away.exceptions.item.ItemNotFoundException;
import com.away.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    ItemRepository itemRepository;
    UserRepository userRepository;
    ItemsMapper itemsMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, UserRepository userRepository, ItemsMapper itemsMapper) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.itemsMapper = itemsMapper;
    }

    public List<ResponseItemDto> getAllItems() {
        return itemsMapper.toResponseItemDTOs(itemRepository.findAll());
    }

    public ResponseItemDto getItemById(long id) {
       ItemEntity item = itemRepository.findById(id).orElseThrow(
               () -> new ItemNotFoundException(id)
       );
       return itemsMapper.toResponseItemDTO(item);
    }

    public List<ResponseItemDto> getAllItemsByUser(long userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
         return itemsMapper.toResponseItemDTOs(itemRepository.findByItemUser(user));
    }

    public ResponseItemDto AddItem(CreateItemDto createItemDto) {
        UserEntity user = userRepository.findByUserId(createItemDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (itemRepository.existsByItemNameAndItemUser(createItemDto.getItemName(), user)) {
            throw new ItemAlreadyExistsException(createItemDto.getUserId());
        }

        ItemEntity itemEntity = itemsMapper.toItemEntity(createItemDto);
        itemEntity.setItemUser(user);

        ItemEntity createdItem = itemRepository.save(itemEntity);
        return itemsMapper.toResponseItemDTO(createdItem);
    }

    public void DeleteItem(long itemId) {
        ItemEntity item = itemRepository.findByItemId(itemId)
                .orElseThrow(()-> new ItemNotFoundException(itemId));
        itemRepository.delete(item);
    }
}
