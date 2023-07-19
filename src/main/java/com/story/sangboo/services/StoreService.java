package com.story.sangboo.services;

import com.story.sangboo.dtos.store.StoreRequestDto;
import com.story.sangboo.dtos.store.StoreResponseDto;
import com.story.sangboo.entities.Store;
import com.story.sangboo.entities.Story;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.StoreRepository;
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
public class StoreService {

    private final StoreRepository repository;
    private final UserRepository userRepository;

    @Transactional
    public Long createStore(StoreRequestDto dto){
        // 가게 등록하기
        Store store = new Store();
//        System.out.println(dto.getStoreName());
//        System.out.println(dto.getUserId());
        store.setStoreName(dto.getStoreName());
        // 유저 정보 불러와서 스토어에 저장하기
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("해당하는 유저 정보가 없습니다."));
        store.setUser(user);
        return repository.save(store).getId();
    }

    @Transactional
    public StoreResponseDto getStore(Long id){
        // 가게 정보 가져오기
        Store store = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 정보가 없습니다"));
        return new StoreResponseDto(store);
    }

    @Transactional
    public Long deleteStoreById(Long id){
        // 가게 삭제하기
        repository.deleteById(id);
        return id;
    }

    @Transactional
    public List<StoreResponseDto> getStores(int page){
        // 가게 목록 불러오기
        Pageable pageable = PageRequest.of(page,30);
        Page<Store> page1 = repository.findAllByPage(pageable);
        List<Store> stores = page1.getContent();
        return stores.stream().map(StoreResponseDto::new).toList();
    }

    @Transactional
    public List<StoreResponseDto> getStoreByUser(Long id){
        List<Store> stores = repository.findAllByUserId(id);
        return stores.stream().map(StoreResponseDto::new).toList();
    }


}
