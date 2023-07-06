package com.story.sangboo.controllers;

import com.story.sangboo.dtos.story.StoryDetailResponseDto;
import com.story.sangboo.dtos.story.StoryListResponseDto;
import com.story.sangboo.dtos.story.StoryRequestDto;
import com.story.sangboo.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/story")
@RestController
@RequiredArgsConstructor
public class StoryApiController {

    private final StoryService service;

    @PostMapping("/{userId}/{storeId}")
    public ResponseEntity<Long> createStory(@PathVariable Long userId, @PathVariable Long storeId, @RequestBody
                                            StoryRequestDto dto){
        // 사연 등록하기
        return ResponseEntity.status(HttpStatus.OK).body(service.CreateStory(dto,userId,storeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryDetailResponseDto> getStoryDetail(@PathVariable Long id){
        // 사연 상세정보 등록하기
        return ResponseEntity.status(HttpStatus.OK).body(service.getStoryDetail(id));
    }

    @GetMapping("/{storeId}/{page}")
    public ResponseEntity<List<StoryListResponseDto>> getStoryList(@PathVariable Long storeId, @PathVariable int page){
        // 사연 리스트 불러오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getStoryList(storeId,page));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteStory(@PathVariable Long id){
        // 사연 삭제하기
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteStory(id));
    }



}
