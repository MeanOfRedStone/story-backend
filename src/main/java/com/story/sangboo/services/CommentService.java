package com.story.sangboo.services;

import com.story.sangboo.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

//    @Transactional
//    public Long createComment(Long id){
//
//    }



}
