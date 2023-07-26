package com.story.sangboo.dtos.song;

import com.story.sangboo.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongResponseDto {

    private Long id;

    private String songName;

    private String artist;

    private String uri;


    public SongResponseDto(Song song){
        this.id = song.getId();
        this.songName = song.getSongName();
        this.artist = song.getArtist();
        this.uri = song.getUri();
    }


}
