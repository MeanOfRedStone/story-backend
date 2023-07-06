package com.story.sangboo.dtos.story;

import com.story.sangboo.entities.Story;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoryListResponseDto {

    private Long id;

    private String username;

    private String emotion;

    private String song;

    private String content;

    public StoryListResponseDto(Story story){
        this.id = story.getId();
        this.username = story.getUser().getUsername();
        this.emotion = story.getEmotion();
        this.song = story.getSong();
        this.content = story.getContent();
    }

}
