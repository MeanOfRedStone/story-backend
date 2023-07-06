package com.story.sangboo.services;

import com.story.sangboo.dtos.comment.CommentRequestDto;
import com.story.sangboo.dtos.comment.CommentResponseDto;
import com.story.sangboo.dtos.comment.CommentUpdateRequestDto;
import com.story.sangboo.dtos.story.StoryListResponseDto;
import com.story.sangboo.entities.Comment;
import com.story.sangboo.entities.Story;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.CommentRepository;
import com.story.sangboo.repositories.StoryRepository;
import com.story.sangboo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final UserRepository userRepository;
    private final StoryRepository storyRepository;

    @Transactional
    public Long createComment(Long storyId, CommentRequestDto dto){
        // 댓글 등록하기
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        // 유저 정보 가져오기
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(()->new RuntimeException("해당 유저가 없습니다."));
        comment.setUser(user);
        // 사연 정보 가져오기
        Story story = storyRepository.findById(storyId)
                .orElseThrow(()->new RuntimeException("해당 사연이 없습니다."));
        comment.setStory(story);
        return repository.save(comment).getId();
    }

    @Transactional
    public List<CommentResponseDto> getCommentList(Long storyId){
        // 사연당 커멘트 불러오기
        List<CommentResponseDto> commentResponseDtos = repository.getCommentListByStoreId(storyId)
                .stream().map(CommentResponseDto::new).collect(Collectors.toList());
        return commentResponseDtos;
    }
    @Transactional
    public Long updateComment(Long id, CommentUpdateRequestDto dto){
        // 댓글 업데이트 하기
        Comment comment =repository.findById(id).orElseThrow(()->new RuntimeException("해당 댓글이 없습니다"));
        comment.setContent(dto.getContent());
        return repository.save(comment).getId();
    }

    @Transactional
    public Long deleteComment(Long id){
        // 댓글 삭제하기
        repository.deleteById(id);
        return id;
    }


}
