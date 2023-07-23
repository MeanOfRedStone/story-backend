package com.story.sangboo.dtos.story;

import com.story.sangboo.entities.Story;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StoryListResponseDto {

    private Long id;

    private String username;

    private String emotion;

    private String content;

    private String songName;

    private String artist;

    private String uri;

    private LocalDateTime modifiedAt;


    public StoryListResponseDto(Story story){
        this.id = story.getId();
        this.username = story.getUser().getUsername();
        this.content = story.getContent();
        this.emotion = story.getEmotion();
        this.songName = story.getSongName();
        this.artist = story.getArtist();
        this.uri = story.getUri();
        this.modifiedAt = story.getSaveAt();


    }

}
