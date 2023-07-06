package com.story.sangboo.dtos.store;


import com.story.sangboo.entities.Store;
import com.story.sangboo.entities.User;
import com.story.sangboo.repositories.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class StoreRequestDto {

    private Long userId;

    private String storeName;

}
