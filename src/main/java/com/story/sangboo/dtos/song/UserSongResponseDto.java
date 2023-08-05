package com.story.sangboo.dtos.song;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSongResponseDto {

    private String emotion;

    private Integer count;

}
