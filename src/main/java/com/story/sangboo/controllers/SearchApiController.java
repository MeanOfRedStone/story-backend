package com.story.sangboo.controllers;

import com.story.sangboo.dtos.search.SearchRequestDto;
import com.story.sangboo.dtos.search.SearchResponseDto;
import com.story.sangboo.entities.Search;
import com.story.sangboo.services.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/search")
@RestController
@RequiredArgsConstructor
public class SearchApiController {

    private final SearchService service;

    @PostMapping
    public ResponseEntity<Long> createSearch(@RequestBody SearchRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.createSearch(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SearchResponseDto>> getSearchList(@PathVariable Long id){
        // 검색한 내역 8개 가져오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getSearchList(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSearch(@PathVariable Long id){
        // 검색어 삭제하기
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteSearch(id));
    }


}
