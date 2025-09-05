package com.away.Services;

import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.db.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(long id) {
        if (itemRepository.existsByItemId(id)) {
            return itemRepository.findByItemId(id);
        } else  {
            /* TODO Item doesn't exist */
            return null;
        }
    }

    public List<ItemEntity> getAllItemsByUser(UserEntity user) {
         return itemRepository.findByItemUser(user);
    }

    public ItemEntity AddItem(ItemEntity itemEntity) {
        if (!itemRepository.existsByItemId(itemEntity.getItemId())) {
            return itemRepository.save(itemEntity);
        }
        else  {
            /* TODO : Item already exists*/
            return null;
        }
    }

    public ItemEntity DeleteItem(ItemEntity itemEntity) {
        if(itemRepository.existsByItemId(itemEntity.getItemId())) {
            itemRepository.delete(itemEntity);
            return itemEntity;
        } else
        {
            /* TODO Item doesn't exist*/
            return null;
        }
    }
}
