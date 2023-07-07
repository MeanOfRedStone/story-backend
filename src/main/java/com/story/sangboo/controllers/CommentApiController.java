package com.story.sangboo.controllers;

import com.story.sangboo.dtos.comment.CommentRequestDto;
import com.story.sangboo.dtos.comment.CommentResponseDto;
import com.story.sangboo.dtos.comment.CommentUpdateRequestDto;
import com.story.sangboo.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService service;

    @PostMapping("/{storyId}")
    public ResponseEntity<Long> createComment(@PathVariable Long storyId, @RequestBody CommentRequestDto dto){
        // 댓글 작성하기
        return ResponseEntity.status(HttpStatus.OK).body(service.createComment(storyId,dto));
    }
    @GetMapping("/{storyId}")
    public ResponseEntity<List<CommentResponseDto>> getCommentList(@PathVariable Long storyId){
        // 사연 당 댓글 불러오기
        return ResponseEntity.status(HttpStatus.OK).body(service.getCommentList(storyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateComment(@PathVariable Long id, @RequestBody CommentUpdateRequestDto dto){
        // 댓글 수정하기
        return ResponseEntity.status(HttpStatus.OK).body(service.updateComment(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteComment(@PathVariable Long id){
        // 댓글 삭제하기
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteComment(id));
    }


}
