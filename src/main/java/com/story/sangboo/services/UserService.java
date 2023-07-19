package com.story.sangboo.services;

import com.story.sangboo.dtos.user.UserRequestDto;
import com.story.sangboo.dtos.user.UserResponseDto;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.CommentRepository;
import com.story.sangboo.repositories.SearchRepository;
import com.story.sangboo.repositories.StoreRepository;
import com.story.sangboo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    //유저 관련 비즈니스 로직

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final CommentRepository commentRepository;
    private final SearchRepository searchRepository;

    @Transactional
    public UserResponseDto getUser(UserResponseDto dto) {
        // 유저 정보 불러오기
        User user = userRepository.findByUsername(dto.getUsername());
        System.out.println(user);
        return new UserResponseDto(user);

    }

    @Transactional
    public Long deleteUserById(Long id){

        // 회원 탈퇴하기
        userRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long updateUsername(Long id, UserRequestDto dto){
        // 회원 닉네임 변경하기
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(dto.getUsername());
            return userRepository.save(user).getId();
        } else {
            throw new RuntimeException("해당하는 유저 정보가 없습니다.");
        }
    }

}
