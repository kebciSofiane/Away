package com.away.controller;

import com.away.Services.DiscoveriesService;
import com.away.db.models.DiscoveryEntity;
import com.away.dto.createDto.CreateDiscoveryDto;
import com.away.dto.responseDto.ResponseDiscoveryDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateDiscoveryDto;
import com.away.dto.updateDto.UpdateUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiscoveryController {

    private final DiscoveriesService discoveryService;

    public DiscoveryController(DiscoveriesService discoveryService) {
        this.discoveryService = discoveryService;
    }

    @GetMapping("/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getAllDiscoveries() {
        List<ResponseDiscoveryDto> responseDiscoveryDtoList = discoveryService.getAllDiscoveries();
        return responseDiscoveryDtoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseDiscoveryDtoList);
    }

    @GetMapping("/discoveries/{id}")
    public ResponseEntity<ResponseDiscoveryDto> getDiscoveryById(@PathVariable long id) {
        return ResponseEntity.ok(discoveryService.getDiscoveryById(id));
    }

    @GetMapping("/items/{itemId}/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getDiscoveriesByItem(@PathVariable long itemId) {
        List<ResponseDiscoveryDto> responseDiscoveryDtoList = discoveryService.getDiscoveryByItem(itemId);
        return responseDiscoveryDtoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseDiscoveryDtoList);
    }

    @GetMapping("/users/{userId}/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getDiscoveriesByUser(@PathVariable long userId) {
        List<ResponseDiscoveryDto> responseDiscoveryDtoList = discoveryService.getDiscoveryByUser(userId);
        return  responseDiscoveryDtoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(responseDiscoveryDtoList);
    }

    @PostMapping("/discoveries")
    public ResponseEntity<ResponseDiscoveryDto> createDiscovery(@RequestBody @Valid CreateDiscoveryDto createDiscoveryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(discoveryService.addDiscovery(createDiscoveryDto));
    }

    @PutMapping("/discoveries/{id}")
    public ResponseEntity<ResponseDiscoveryDto> updateDiscovery(@RequestBody @Valid UpdateDiscoveryDto updateDiscoveryDto, @PathVariable long id) {
        return ResponseEntity.ok(discoveryService.updateDiscovery(updateDiscoveryDto, id));
    }

    @DeleteMapping("/discoveries/{id}")
    public ResponseEntity<Void> deleteDiscovery(@PathVariable long id) {
        discoveryService.deleteDiscovery(id);
        return ResponseEntity.noContent().build();
    }
}
