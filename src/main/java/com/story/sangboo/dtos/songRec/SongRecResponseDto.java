package com.story.sangboo.dtos.songRec;

import com.story.sangboo.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongRecResponseDto {

    private String songName;

    private String artist;

    private String uri;

    private String emotion;

    public SongRecResponseDto(Song song){
        this.songName = song.getSongName();
        this.artist = song.getArtist();
        this.uri = song.getUri();
        this.emotion = song.getEmotion();
    }

}
