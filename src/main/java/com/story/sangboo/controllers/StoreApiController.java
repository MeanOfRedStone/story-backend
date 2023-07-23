package com.story.sangboo.controllers;

import com.story.sangboo.dtos.store.StoreRequestDto;
import com.story.sangboo.dtos.store.StoreResponseDto;
import com.story.sangboo.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreApiController {

    private final StoreService service;

    @PostMapping
    public ResponseEntity<Long> createStore(@RequestBody StoreRequestDto dto){
        // 가게 정보 등록하기
        return ResponseEntity.status(HttpStatus.OK).body(service.createStore(dto));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<StoreResponseDto> getStoreById(@PathVariable Long id){
        // 가게 정보 불러오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getStore(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteStoreById(@PathVariable Long id){
        // 가게 삭제하기
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteStoreById(id));
    }

    @GetMapping("/{page}")
    public ResponseEntity<List<StoreResponseDto>> getStores(@PathVariable int page){
        // 가게 리스트 불러오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getStores(page));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<StoreResponseDto>> getStoresByUserId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getStoreByUser(id));
    }



}
