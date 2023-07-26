package com.story.sangboo.services;


import com.story.sangboo.dtos.story.StoryDetailResponseDto;
import com.story.sangboo.dtos.story.StoryListResponseDto;
import com.story.sangboo.dtos.story.StoryRequestDto;
import com.story.sangboo.entities.Store;
import com.story.sangboo.entities.Story;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.StoreRepository;
import com.story.sangboo.repositories.StoryRepository;
import com.story.sangboo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository repository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;


    @Transactional
    public Long CreateStory(StoryRequestDto dto,Long userId, Long storeId){
        // 사연 생성
        Story story = dto.toStory(dto);
//        story.setSongName();
//        story.setEmotion(dto.getEmotion());
//        story.setContent(dto.getContent());
        // ID 에 맞는 유저 불러오기
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다"));
        story.setUser(user);
        // ID 에 맞는 가게 불러오기
        Store store = storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("존재하지 않는 가게입니다"));
        story.setStore(store);
        return repository.save(story).getId();

    }

    @Transactional
    public StoryListResponseDto getStoryDetail(Long id){
        // 사연 상세 정보 불러오기
        Story story = repository.findById(id).orElseThrow(
                ()->new RuntimeException("해당 게시물은 존재하지 않습니다.")
        );
        return new StoryListResponseDto(story);
    }

    @Transactional
    public List<StoryListResponseDto> getStoryList(Long storeId){
        // 사연 리스트 15 개씩 불러오게 만들기
        List<Story> storyList = repository.findAllByStoreId(storeId);
        List<StoryListResponseDto> storyListResponseDtos = storyList.stream().map(
                StoryListResponseDto::new).collect(Collectors.toList());
        return storyListResponseDtos;
    }

    @Transactional
    public Long deleteStory(Long id){
        // 사연 삭제하기
        repository.deleteById(id);
        return id;
    }


}
