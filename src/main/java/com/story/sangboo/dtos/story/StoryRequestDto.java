package com.story.sangboo.dtos.story;


import com.story.sangboo.entities.Story;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoryRequestDto {

    private String emotion;

    private String content;

// Song information ( nullable = false )
    private String songName;

    private String artist;

    private String uri;

    public Story toStory(StoryRequestDto dto){
        Story story = Story.builder()
                .emotion(dto.getEmotion())
                .content(dto.getContent())
                .songName(dto.getSongName())
                .artist(dto.getArtist())
                .uri(dto.getUri())
                .build();
        return story;
    }

}
