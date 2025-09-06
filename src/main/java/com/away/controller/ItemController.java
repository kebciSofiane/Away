package com.away.controller;

import com.away.Services.ItemService;
import com.away.db.models.ItemEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/")
    public ResponseEntity<List<ItemEntity>> getItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemEntity>   getItemById( @PathVariable long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/items")
    public ResponseEntity<List<ItemEntity>> getItemsByUser(@PathVariable long userId) {
        return new ResponseEntity<>(itemService.getAllItemsByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity itemEntity) {
        return new ResponseEntity<>(itemService.AddItem(itemEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        itemService.DeleteItem(id);
        return ResponseEntity.noContent().build();
    }





}
