package com.away.controller;

import com.away.Services.ItemService;
import com.away.db.models.ItemEntity;
import com.away.dto.createDto.CreateItemDto;
import com.away.dto.responseDto.ResponseItemDto;
import com.away.dto.responseDto.ResponseUserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/")
    public ResponseEntity<List<ResponseItemDto>> getItems() {
        List<ResponseItemDto>  responseItemDtoList =  itemService.getAllItems();
        return responseItemDtoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseItemDtoList);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ResponseItemDto>   getItemById( @PathVariable long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @GetMapping("/users/{userId}/items")
    public ResponseEntity<List<ResponseItemDto>> getItemsByUser(@PathVariable long userId) {
        List<ResponseItemDto>  responseItemDtoList =  itemService.getAllItemsByUser(userId);
        return responseItemDtoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseItemDtoList);
    }

    @PostMapping("/items")
    public ResponseEntity<ResponseItemDto> addItem(@RequestBody @Valid CreateItemDto itemEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.AddItem(itemEntity));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        itemService.DeleteItem(id);
        return ResponseEntity.noContent().build();
    }





}
