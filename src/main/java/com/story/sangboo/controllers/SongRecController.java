package com.story.sangboo.controllers;

import com.story.sangboo.dtos.songRec.SongRecRequestDto;
import com.story.sangboo.dtos.songRec.SongRecResponseDto;
import com.story.sangboo.services.SongRecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/songRec")
@RequiredArgsConstructor
public class SongRecController {

    private final SongRecService service;


    @PostMapping
    public ResponseEntity<SongRecResponseDto> findRandByEmotion(@RequestBody SongRecRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.randomSongRec(dto));
    }



}
