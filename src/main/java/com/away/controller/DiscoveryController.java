package com.away.controller;

import com.away.Services.DiscoveriesService;
import com.away.db.models.DiscoveryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscoveryController {

    private DiscoveriesService discoveryService;

    @Autowired
    public DiscoveryController(DiscoveriesService discoveryService) {
        this.discoveryService = discoveryService;
    }

    @GetMapping("/discoveries/")
    public ResponseEntity<List<DiscoveryEntity>> discoveries() {
        return new ResponseEntity<>(discoveryService.getAllDiscoveries(), HttpStatus.OK);
    }

    @GetMapping("/discoveries/{id}")
    public ResponseEntity<DiscoveryEntity> discovery(@PathVariable long id) {
        return new ResponseEntity<>(discoveryService.getDiscoveryById(id), HttpStatus.OK);
    }

    @GetMapping("/items/{itemId}/discoveries")
    public ResponseEntity<List<DiscoveryEntity>> getDiscoveriesByItem(@PathVariable long itemId) {
        return new ResponseEntity<>(discoveryService.getDiscoveryByItem(itemId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/discoveries")
    public ResponseEntity<List<DiscoveryEntity>> getDiscoveriesByUser(@PathVariable long userId) {
        return new ResponseEntity<>(discoveryService.getDiscoveryByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/discoveries/")
    public ResponseEntity<DiscoveryEntity> createDiscovery(@RequestBody DiscoveryEntity discoveryEntity) {
        return new ResponseEntity<>(discoveryService.addDiscovery(discoveryEntity), HttpStatus.CREATED );
    }

    @DeleteMapping("/discoveries/{id}")
    public ResponseEntity<DiscoveryEntity> deleteDiscovery(@PathVariable long id) {
        discoveryService.deleteDiscovery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
