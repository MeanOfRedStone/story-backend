package com.story.sangboo.dtos.story;

import com.story.sangboo.entities.Story;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StoryDetailResponseDto {

    private Long id;

    private Long storeId;

    private String storeName;

    private Long userId;

    private String username;

    private String emotion;

    private String content;

    private LocalDateTime saveAt;

    public StoryDetailResponseDto(Story story){
        this.id = story.getId();
        this.storeId = story.getStore().getId();
        this.storeName = story.getStore().getStoreName();
        this.userId = story.getUser().getId();
        this.username = story.getUser().getUsername();
        this.emotion = story.getEmotion();
        this.content = story.getContent();
        this.saveAt = story.getSaveAt();
    }


}
