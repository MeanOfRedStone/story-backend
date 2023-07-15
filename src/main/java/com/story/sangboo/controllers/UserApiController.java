package com.story.sangboo.controllers;

import com.story.sangboo.dtos.user.UserRequestDto;
import com.story.sangboo.dtos.user.UserResponseDto;
import com.story.sangboo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDto> getUser(@RequestBody UserResponseDto dto){
        // 유저 정보 가져오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getUser(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        // 유저 삭제하기
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto){
        // 유저 닉네임 업데이트하기
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUsername(id,dto));
    }

}
