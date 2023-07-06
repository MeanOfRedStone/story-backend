package com.story.sangboo.services;

import com.story.sangboo.dtos.search.SearchRequestDto;
import com.story.sangboo.dtos.search.SearchResponseDto;
import com.story.sangboo.entities.Search;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.SearchRepository;
import com.story.sangboo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository repository;

    private final UserRepository userRepository;

    @Transactional
    public Long createSearch(SearchRequestDto dto){
        // 검색어 저장하는 메서드
        Search search = new Search();
        search.setSearch(dto.getSearch());
        User user= userRepository.findById(dto.getUserId()).orElseThrow(()->new RuntimeException("해당 유저가 없습니다"));
        search.setUser(user);
        return repository.save(search).getId();
    }

    @Transactional
    public List<SearchResponseDto> getSearchList(Long id){
        // 검색한 내역 알고리즘

        List<Search> searchList = repository.findTop60ByOrderById(id);
        Collections.reverse(searchList);
        // 중복된 search 값 중 ID 값이 가장 높은 데이터를 유지하기 위한 맵
        Map<String, Search> searchMap = new LinkedHashMap<>();

        // Map의 키값을 이용하여 중복제거 및 ID가 큰 순서 남기기
        for (Search search : searchList) {
            searchMap.put(search.getSearch(), search);
        }
        // sort를 사용하여 역순으로 정렬한다.
        List<SearchResponseDto> result = searchMap.values().stream()
                .sorted(Comparator.comparing(Search::getId).reversed())
                .map(SearchResponseDto::new)
                .collect(Collectors.toList());

        return result.subList(0, Math.min(result.size(), 7));
    }

    @Transactional
    public String deleteSearch(Long id){
        // 검색어 삭제시 해당 검색어 전체 삭제하기
        Search search = repository.findById(id).orElseThrow(()->new RuntimeException("존재하지 않는 검색어입니다"));
        repository.deleteBySearch(search.getSearch(),search.getUser().getId());
        return search.getSearch();
    }

}
