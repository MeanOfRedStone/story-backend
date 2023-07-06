package com.story.sangboo.dtos.user;

import com.story.sangboo.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private Long id;

    private String username;

    private String userid;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.userid = user.getUserid();
    }

}
