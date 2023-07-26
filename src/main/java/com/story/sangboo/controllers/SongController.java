package com.story.sangboo.controllers;

import com.story.sangboo.dtos.song.SongRequestDto;
import com.story.sangboo.dtos.song.SongResponseDto;
import com.story.sangboo.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/song")
public class SongController {

    private final SongService service;

    @PostMapping
    public ResponseEntity<List<SongResponseDto>> findAllBySearch (@RequestBody SongRequestDto dto){
        System.out.println(dto.getSearch());
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllBySearch(dto));
    }


}
