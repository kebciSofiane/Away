package com.away.controller;

import com.away.Services.DiscoveriesService;
import com.away.db.models.DiscoveryEntity;
import com.away.dto.createDto.CreateDiscoveryDto;
import com.away.dto.responseDto.ResponseDiscoveryDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateDiscoveryDto;
import com.away.dto.updateDto.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscoveryController {

    private final DiscoveriesService discoveryService;

    public DiscoveryController(DiscoveriesService discoveryService) {
        this.discoveryService = discoveryService;
    }

    @GetMapping("/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getAllDiscoveries() {
        return new ResponseEntity<>(discoveryService.getAllDiscoveries(), HttpStatus.OK);
    }

    @GetMapping("/discoveries/{id}")
    public ResponseEntity<ResponseDiscoveryDto> getDiscoveryById(@PathVariable long id) {
        return new ResponseEntity<>(discoveryService.getDiscoveryById(id), HttpStatus.OK);
    }

    @GetMapping("/items/{itemId}/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getDiscoveriesByItem(@PathVariable long itemId) {
        return new ResponseEntity<>(discoveryService.getDiscoveryByItem(itemId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/discoveries")
    public ResponseEntity<List<ResponseDiscoveryDto>> getDiscoveriesByUser(@PathVariable long userId) {
        return new ResponseEntity<>(discoveryService.getDiscoveryByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/discoveries")
    public ResponseEntity<ResponseDiscoveryDto> createDiscovery(@RequestBody CreateDiscoveryDto createDiscoveryDto) {
        return new ResponseEntity<>(discoveryService.addDiscovery(createDiscoveryDto), HttpStatus.CREATED );
    }

    @PutMapping("/discoveries/{id}")
    public ResponseEntity<ResponseDiscoveryDto> updateUser(@RequestBody UpdateDiscoveryDto updateDiscoveryDto, @PathVariable long id) {
        return new ResponseEntity<>(discoveryService.updateDiscovery(updateDiscoveryDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/discoveries/{id}")
    public ResponseEntity<Void> deleteDiscovery(@PathVariable long id) {
        discoveryService.deleteDiscovery(id);
        return ResponseEntity.noContent().build();
    }
}
