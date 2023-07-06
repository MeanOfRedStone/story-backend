package com.story.sangboo.dtos.story;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoryRequestDto {

    private String song;

    private String emotion;

    private String content;

}
