package com.story.sangboo.controllers;

import com.story.sangboo.dtos.song.SongRequestDto;
import com.story.sangboo.dtos.song.SongResponseDto;
import com.story.sangboo.dtos.song.UserSongResponseDto;
import com.story.sangboo.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<List<UserSongResponseDto>> findAllEmoBByUser (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllEmotionByUser(id));
    }
    @GetMapping("/store/{id}")
    public ResponseEntity<List<UserSongResponseDto>> findAllEmoBByStore (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllEmotionByStore(id));
    }


}
